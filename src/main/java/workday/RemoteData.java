package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class RemoteData {

    /*
Before migration:
Statistics of total: count[70429], min[24], max[943], avg[31.4], median[31]
Statistics of fetch: count[70429], min[1], max[912], avg[2.1], median[2]

Before the pool patch:
Statistics of total: count[8860], min[114], max[19521], avg[1578.7], median[946]
Statistics of fetch: count[8860], min[36], max[2727], avg[102.1], median[46]

Latest:
Statistics of total: count[125118], min[114], max[17408], avg[137.4], median[138]
Statistics of fetch: count[125118], min[37], max[17058], avg[45.7], median[46]
    * */
    public static void main(String[] args)
        throws Exception {

        List<Integer> totals = new ArrayList<>();
        List<Integer> fetches = new ArrayList<>();

        final AtomicInteger sum = new AtomicInteger();

        Files.walk(Paths.get("/Users/baofeng.xue/Downloads/_tomcat.oms.ots_2021.46.110_logs"))
            //Files.walk(Paths.get("/Users/baofeng.xue/Downloads/_tomcat.oms.ots_2021.35.129_logs (1)"))
            //Files.walk(Paths.get("/Users/baofeng.xue/Downloads/remote_data 2.log"))
            .filter(p -> p.toString().contains("remote_data"))
            .forEach(
                f -> {
                    Stream<String> lines = null;
                    try {
                        lines = Files.lines(f);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    lines.filter(l -> l.contains("WATS.jira") || l.contains("watsdb.jira"))
                        .forEach(
                            l -> {
                                sum.getAndIncrement();
                                String[] split;
                                if (l.contains("watsdb.jira")) {
                                    split = l.split("watsdb.jira,")[1].split(",");
                                }
                                else {
                                    split = l.split("WATS.jira,")[1].split(",");
                                }
                                int v1 = Integer.parseInt(split[1]);
                                totals.add(v1);
                                int v2 = Integer.parseInt(split[2]);
                                fetches.add(v2);
                            }
                                );
                }
                    );

        IntSummaryStatistics totalS = totals.stream().mapToInt(Integer::valueOf).summaryStatistics();
        IntSummaryStatistics fetchesStat = fetches.stream().mapToInt(Integer::valueOf).summaryStatistics();
        String format = ": count[%s], min[%s], max[%s], avg[%.1f], median[%s]";
        System.out.println(String.format("Statistics of total" + format,
            sum.get(),
            totalS.getMin(),
            totalS.getMax(),
            totalS.getAverage(),
            median(totals)
                                        ));
        System.out.println(String.format("Statistics of fetch" + format,
            sum.get(),
            fetchesStat.getMin(),
            fetchesStat.getMax(),
            fetchesStat.getAverage(),
            median(fetches)
                                        ));
    }

    private static int median(final List<Integer> durations) {
        Collections.sort(durations);
        return durations.get(durations.size() / 2);
    }
}

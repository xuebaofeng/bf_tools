package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class RemoteData {
/*
IntSummaryStatistics{count=293, sum=113760, min=114, average=388.259386, max=17408}
IntSummaryStatistics{count=199, sum=52560, min=37, average=264.120603, max=17058}
IntSummaryStatistics{count=247, sum=64101, min=77, average=259.518219, max=2169}
261
141
201
* */
    public static void main(String[] args)
        throws Exception {

        Set<Integer> totals = new HashSet<>();
        Set<Integer> fetches = new HashSet<>();
        Set<Integer> diffs = new HashSet<>();

        final AtomicInteger sum = new AtomicInteger();

        Files.walk(Path.of("/Users/baofeng.xue/Downloads"))
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

                    lines.filter(l -> l.contains("watsdb.jira"))
                        .forEach(
                            l -> {
                                sum.getAndIncrement();
                                String[] split = l.split("watsdb.jira,")[1].split(",");
                                int v1 = Integer.parseInt(split[1]);
                                totals.add(v1);
                                int v2 = Integer.parseInt(split[2]);
                                fetches.add(v2);
                                diffs.add(v1 - v2);
                            }
                                );
                }
                    );

        IntSummaryStatistics totalS = totals.stream().mapToInt(Integer::valueOf).summaryStatistics();
        IntSummaryStatistics fetchesStat = fetches.stream().mapToInt(Integer::valueOf).summaryStatistics();
        IntSummaryStatistics diffsStat = diffs.stream().mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println(fetchesStat);
        System.out.println(diffsStat);
        System.out.println(String.format("Statistics of total time of remote data: invocation count[%s], min[%s], max[%s], avg[%s], median[%s]",
            sum.get(),
            totalS.getMin(),
            totalS.getMax(),
            totalS.getAverage(),
            median(totals)
            ));
    }

    private static int median(final Set<Integer> durations) {
        ArrayList<Integer> integers = new ArrayList<>(durations);
        Collections.sort(integers);
        return integers.get(integers.size() / 2);
    }
}

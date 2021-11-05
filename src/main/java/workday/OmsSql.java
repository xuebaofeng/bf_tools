package workday;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OmsSql {
    public static void main(String[] args) throws Exception{
        Stream<String> lines = Files.lines(
            Paths.get("/Users/baofeng.xue/Downloads/master_tomcat.oms.ots_2021.32.086_logs/oms_sql_stats.log"));
        Map<String, Long> counted = lines.filter(l -> l.contains("watsdb,") && l.contains("FROM"))
            .map(l -> l.split("FROM ")[1].split(" ")[0])
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counted);
    }
}

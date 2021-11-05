package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoteDataCount {
    public static void main(String[] args) throws Exception {

        Files.walk(Path.of("/Users/baofeng.xue/Downloads")).filter(p -> p.toString().contains("remote_data")).forEach(
            f -> {
                Stream<String> lines = null;
                try {
                    lines = Files.lines(f);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                lines.filter(l -> l.contains("watsdb."))
                    .map(l -> l.split("watsdb.")[1].split(",")[0])
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(System.out::println);
            }
                                                                                                                     );

    }
}

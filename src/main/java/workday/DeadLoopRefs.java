package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeadLoopRefs {

    public static void main(String[] args)
        throws IOException {

        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get("dead-loop.log"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        lines.map(l -> l.split("rltn\\[")[1].split("\\]")[0])
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);

    }

}

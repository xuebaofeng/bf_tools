package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author baofeng.xue
 * @since Sep-2022
 */
public class TestDisabler {

    private static final String DISABLED = "@org.junit.jupiter.api.Disabled";

    public static void main(String[] args)
        throws IOException {

        Set<String> cats = new HashSet<>();

        List<Path> javaFiles = Files.walk(
                Path.of("/Users/baofeng.xue/code/oms/omsbase/src/test/java/com/workday/instancedata/relationship/"),
                1)
            .filter(path -> {
                if (path.toFile().isDirectory()) {
                    return false;
                }
                try {
                    List<String> lines = Files.readAllLines(path);
                    boolean isTest = false;
                    for (String line : lines) {

                        if (line.contains("OmsTestCategories")) {
                            cats.add(line);
                        }

                        if (line.contains("OmsTestCategories.METADATA_UPDATE") || line.contains(
                            "OmsTestCategories.UNIT") || line.contains(DISABLED)) {
                            return false;
                        }
                        if (line.contains("OmsTestCategories")) {
                            isTest = true;
                        }
                    }
                    if (!isTest) {
                        return false;
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            })
            .sorted()
            .collect(Collectors.toList());

        for (int i = javaFiles.size()/4*3; i < javaFiles.size()/8*7; i++) {
            final Path path = javaFiles.get(i);
            List<String> lines = Files.readAllLines(path);
            for (int j = 0; j < lines.size(); j++) {
                final String line = lines.get(j);
                if (line.contains("@Tag(OmsTestCategories.")) {
                    lines.add(j, DISABLED);
                    Files.writeString(path, String.join("\n", lines));
                    break;
                }
            }
        }
    }
}

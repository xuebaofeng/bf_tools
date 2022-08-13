package workday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baofeng.xue
 * @since Aug-2022
 */
public class MultiGrep {

    public static void main(String[] args)
        throws IOException {
        Set<Path> s = new HashSet<>();

        String[] words = {"OmsTestCategories.UNIT", "ToggleTestUtils.enabledToggleForTenant"};

        Files.walk(Paths.get("/Users/baofeng.xue/code/oms"))
            .filter(p -> p.toString().endsWith(".java"))
            .forEach(
                f -> {
                    try {
                        List<String> strings = Files.readAllLines(f);
                        boolean[] found = new boolean[words.length];
                        for (String string : strings) {
                            for (int i = 0; i < words.length; i++) {
                                final String word = words[i];
                                if (string.contains(word)) {
                                    found[i]=true;
                                }
                            }

                            boolean allFound = true;
                            for (boolean b : found) {
                                allFound = allFound && b;
                            }

                            if (allFound) {
                                s.add(f);
                                break;
                            }
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println(s);
    }

}

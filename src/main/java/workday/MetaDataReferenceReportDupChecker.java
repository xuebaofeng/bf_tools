package workday;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baofeng.xue
 * @since Sep-2022
 */
public class MetaDataReferenceReportDupChecker {

    public static void main(String[] args)
        throws Exception {
        List<String> allLines = Files.readAllLines(Paths.get(
            "/Users/baofeng.xue/Downloads/build-logs (3)/_logs/beforeBounceAllWithoutEms/ots/referenced_metadata_dist.csv"));
        Set<String> unique = new HashSet<>();
        int count = 0;
        for (int i = 1; i < allLines.size(); i++) {
            final String line = allLines.get(i);
            //2022-12-07 13:51:56.960 -0800,oms,SUDEV,3266,1308,121
            String[] split = line.split(" -0800,");
            if (!unique.add(split[1])) {
                System.out.println(line);
                count++;
            }
        }
        System.out.println(allLines.size());
        System.out.println(count);
        System.out.println(count / allLines.size());
    }

}

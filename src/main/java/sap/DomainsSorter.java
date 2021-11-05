package sap;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DomainsSorter {
	public static void main(String[] args) throws Exception{
		Stream<String> lines = Files.lines(Paths.get("C:\\Users\\i854966\\Downloads\\Producrtion-Hosts-2019-02-28.txt"));
		lines.filter(
			l -> l.startsWith("http")
				&& !l.contains("wiki")
				&& !l.contains("confluence")
		)
			.sorted()
			.map(l -> {
				l = l.trim();
				String[] split = l.split("/");
				l = split[0] + "//" + split[1] + split[2];
				int i = l.lastIndexOf(".");
				String root = l.substring(i);
				String row = l + "|https://www.successfactors" + root;
				if(
					row.contains("hcm12preview")
						|| row.contains("performancemanager5")
						|| row.contains("performancemanagerrot")
						|| row.contains("hcm12dr")
				){
					row = row + ".com";
				}else{
					row = row + root;
				}
				if(row.contains("performancemanager5")) row = row.replace("https://www", "www");
				return row;
			})
			.distinct()
			.forEach(System.out::println);
	}
}

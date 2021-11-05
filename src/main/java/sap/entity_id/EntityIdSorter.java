package sap.entity_id;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EntityIdSorter {
	public static void main(String[] args) throws Exception{
		Stream<String> existing = Files.lines(Paths.get("C:\\wbem\\github\\trunk\\au-V4\\au-V4-service\\src\\main\\resources\\dataCenterSAML2EntityIDMap.properties"));
		existing.filter(l -> l.startsWith("http"))
			.map(l -> {
				String[] split = l.split("\\|");
				String url = split[0];
				String dc = url.replaceAll("[^0-9]", "");
				if(dc.equals("")) dc = "999";
				if(dc.length() == 1) dc = "0" + dc;
				return dc + " " + split[1];
			})
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}
}

package sap;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DomainsSorterV0 {
	public static void main(String[] args) throws Exception{
		Stream<String> existing = Files.lines(Paths.get("C:\\wbem\\github\\trunk\\au-V4\\au-V4-service\\src\\main\\resources\\dataCenterSAML2EntityIDMap.properties"));
		existing.filter(l -> l.startsWith("http"))
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}
}

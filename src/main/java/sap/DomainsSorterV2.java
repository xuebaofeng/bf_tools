package sap;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomainsSorterV2 {
	public static void main(String[] args) throws Exception{
		Stream<String> existing = Files.lines(Paths.get("C:\\wbem\\github\\trunk\\au-V4\\au-V4-service\\src\\main\\resources\\dataCenterSAML2EntityIDMap.properties"));
		Set<String> hosts = existing.map(l -> l.split("\\|")[0].trim())
			.collect(Collectors.toSet());
		Stream<String> lines = Files.lines(Paths.get("C:\\Users\\i854966\\Downloads\\Producrtion-Hosts-2019-02-28.txt"));
		lines.filter(
			l -> l.startsWith("http")
				&& !l.contains("wiki")
				&& !l.contains("confluence")
		)
			.map(l -> {
				l = l.trim();
				String[] split = l.split("/");
				l = split[0] + "//" + split[1] + split[2];
				return l;
			})
			.distinct()
			.filter(
				l -> !hosts.contains(l)
			)
			.sorted()
			.map(l -> l + "|https://www.successfactors.com")
			.forEach(System.out::println);
	}
}

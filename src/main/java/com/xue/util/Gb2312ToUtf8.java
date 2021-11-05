package com.xue.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gb2312ToUtf8 {

	public static void main(String[] args) throws Exception{
		ArrayList<Path> list = Files.walk(Paths.get("D:\\backup\\media\\tv\\futurama"))
			.filter(
				(path) -> {
					String s = path.toString();
					return Files.isRegularFile(path)
						&& s.contains(".chn")
						&& !s.endsWith(".bak");
				}
			)
			.collect(Collectors.toCollection(ArrayList::new));
		for(Path path: list){
			Path copied = Paths.get(path.toFile().getAbsoluteFile() + ".bak");
			if(!copied.toFile().exists()){
				Files.copy(path, copied, StandardCopyOption.REPLACE_EXISTING);
			}

//            String cmd = String.format("iconv  -f gb2312 -t utf-8 \"%s\"", copied.toFile().getName());
			String cmd = String.format("iconv  -f gb2312 -t utf-8 \"%s\" > \"%s\"", copied.toFile().getName(), path.toFile().getName());
			System.out.println(cmd);
		}
	}

	static List<String> readFile(Path path) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), "gb2312"));
		return reader.lines().collect(Collectors.toCollection(ArrayList::new));
	}
}

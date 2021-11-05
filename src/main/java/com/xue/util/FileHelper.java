package com.xue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Baofeng Xue at 7/2/2014.
 */
public class FileHelper {

	final static Logger logger = LoggerFactory.getLogger(FileHelper.class);

	static Path saveToFile(String content, String filePath){
		Path file = Paths.get(filePath);
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedWriter writer = Files.newBufferedWriter(file, charset)){
			writer.write(content);
		}catch(IOException x){
			logger.error("{}", x);
		}
		logger.debug("content:{}", content);
		logger.debug("saveToFile:{}", file);
		return file;
	}

	public static String read(String path){
		List<String> strings;
		try{
			strings = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
		}catch(IOException e){
			e.printStackTrace();
			return "";
		}
		String ret = "";
		for(String line: strings){
			ret += line + "\n";
		}
		logger.debug("content:{}" + ret);
		return ret;
	}

	public static List<String> readLines(String path){
		try{
			return Files.readAllLines(Paths.get(path), Charset.defaultCharset());
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}

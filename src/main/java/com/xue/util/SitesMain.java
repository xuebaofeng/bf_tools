package com.xue.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class SitesMain {
	private static Map<String, Integer> words = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);

	private static void sort() throws IOException{

		BufferedReader reader = new BufferedReader(new InputStreamReader(SitesMain.class.getResourceAsStream("/it.txt")));
		String line;
		while((line = reader.readLine()) != null){
			String[] wordsInLine = line.split(",| |，|/|、|：|:|；|;|\\\\|。|与|和|等|都|其余|一些|一般|的|是|主要|关注|及|看|比如|相关|源码|牛人|技术|百度|大牛|各种|官方|官网|个人|几个" +
				"|各个|有|相对|相当|相应|邮件|根据|然后|论坛|网站|社区|订阅|问题|搜索|查询|感兴趣|不知道|为什么|另外|可以|可能|项目|很多|怎么|不|经常|比较|基本|上");

			for(String word: wordsInLine){
				word = word.toLowerCase();
				word = word.replace("1.", "");
				word = word.replace("2.", "");
				word = word.replace("3.", "");
				word = word.replace(".", "");
				word = word.replace("都会", "");
				word = word.replace("开源社区", "");

				if(word.startsWith("www")) word = word.substring(3, word.length());
				if(word.endsWith("comcn")) word = word.substring(0, word.length() - 5);
				if(word.endsWith("com") || word.endsWith("net")) word = word.substring(0, word.length() - 3);

				if(word.length() < 3) continue;

				if("http".equals(word)) continue;
				if("https".equals(word)) continue;
				if("bbs".equals(word)) continue;
				if("blog".equals(word)) continue;
				if("blogs".equals(word)) continue;
				if("group".equals(word)) continue;
				if("groups".equals(word)) continue;
				if("news".equals(word)) continue;

				if("51test".equals(word) || "51tesing".equals(word)) word = "51testing";
				if("androi".equals(word) || "androidde".equals(word) || "android-developer".equals(word)) word = "android";
				if("apacheorg".equals(word)) word = "apache";
				if("开源中国".equals(word)) word = "oschina";
				if("javaeye".equals(word) || "ieeye".equals(word) || "ifeve".equals(word) || "ifeye".equals(word) || "javaeys".equals(word) || "javeeye".equals(word) || "ite".equals(word)
					|| "it眼".equals(word)) word = "iteye";
				if("stackflow".equals(word) || "overflow".equals(word) || "stack".equals(word) || "stack".equals(word) || "stackoverfl".equals(word) || "stac".equals(word))
					word = "stackoverflow";
				if("cdsn".equals(word) || "csdnnet".equals(word) || "csdn博客".equals(word) || "程序员".equals(word)) word = "csdn";
				if("cnblogs".equals(word) || "博客园".equals(word)) word = "cnblog";
				if("google+".equals(word)) word = "google";

				if(words.containsKey(word))
					words.put(word, words.get(word) + 1);
				else
					words.put(word, 1);
			}

		}
		reader.close();
		words = MapUtil.sortByValue(words);
		for(Map.Entry<String, Integer> item: words.entrySet()){
			System.out.println(item.getKey() + "\t" + item.getValue());
		}
	}

	public static void main(String args[]) throws IOException{
		sort();
	}
}

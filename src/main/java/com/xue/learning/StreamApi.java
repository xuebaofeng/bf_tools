package com.xue.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2015/12/5.
 */
public class StreamApi {

	public static void main(String[] args){
		List<String> l = Arrays.asList("baofeng", "xue");

		l.forEach(System.out::println);

		l.stream()
			.filter(s -> s.length() > 5)
			.map(String::toUpperCase)
			.forEach(System.out::println);

		System.out.println(IntStream.rangeClosed(2, 12).sum() == (2 + 12) * (12 - 2 + 1) / 2);
	}
}

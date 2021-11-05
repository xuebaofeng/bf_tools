package com.xue.test;

import java.nio.charset.StandardCharsets;

public class StringLength {
	public static void main(String[] args){
		System.out.println("a".getBytes(StandardCharsets.UTF_8).length);
		System.out.println("\u1000".getBytes(StandardCharsets.UTF_8).length);
		System.out.println("\u10000".getBytes(StandardCharsets.UTF_8).length);
		System.out.println("\u100000".getBytes(StandardCharsets.UTF_8).length);
		System.out.println("汉".getBytes(StandardCharsets.UTF_8).length);
	}
}

package com.xue.test;

public class Split {
	public static void main(String[] args){
		String[] split = "&a=1&b=".split("&");
		for(String s: split){
			System.out.println(s);
		}

		split = "30特殊照顾.m4a".split("^\\d*");
		for(String s: split){
			System.out.println(s);
		}
	}
}

package com.xue.test;

import java.util.Locale;

public class LocaleTest {
	public static void main(String[] args){
		Locale locale = new Locale("zh");
		System.out.println(locale.toLanguageTag());
	}
}

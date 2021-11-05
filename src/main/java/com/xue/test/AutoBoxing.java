package com.xue.test;

/**
 * @author xuebaofeng  薛保锋
 */
public class AutoBoxing {
	private Long aLong;

	public static void main(String[] args){
		AutoBoxing autoBoxing = new AutoBoxing();
		System.out.println(autoBoxing.aLong);
		System.out.println(autoBoxing.aLong == 0);
	}
}

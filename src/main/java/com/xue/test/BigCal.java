package com.xue.test;

import java.math.BigDecimal;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * @author xuebaofeng
 */
public class BigCal {
	public static void main(String[] args){
		BigDecimal a = new BigDecimal(1.1);
		for(int i = 0; i < Integer.MAX_VALUE; i++){
			a = a.multiply(a);
			System.out.println(a);

		}
	}
}

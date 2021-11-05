package com.xue.test;

import java.util.LinkedList;

/**
 * @author Baofeng Xue at 2015/10/24 17:18.
 */
public class Numerb2Digital {
	public static void main(String[] args){
		int number = 123; // = and int
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while(number > 0){
			stack.push(number % 10);
			number = number / 10;
		}

		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println(1 / 10);
	}
}

package com.xue.test;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

	private TreeMap<Integer, Integer> map;

	public MyCalendarTwo(){
		map = new TreeMap<>();
	}

	public boolean book(int start, int end){
		map.put(start, map.getOrDefault(start, 0) + 1);
		map.put(end, map.getOrDefault(end, 0) - 1);
		int count = 0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			count += entry.getValue();
			if(count > 2){
				map.put(start, map.get(start) - 1);
				if(map.get(start) == 0){
					map.remove(start);
				}
				map.put(end, map.get(end) + 1);
				if(map.get(end) == 0){
					map.remove(end);
				}
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
		myCalendarTwo.book(10, 20); // returns true
		myCalendarTwo.book(50, 60); // returns true
		myCalendarTwo.book(10, 40); // returns true
		myCalendarTwo.book(5, 15); // returns false
		myCalendarTwo.book(5, 10); // returns true
		myCalendarTwo.book(25, 55); // returns true
	}
}

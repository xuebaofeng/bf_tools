package com.xue.amazon;

import java.util.*;

//Count LRU Cache Misses
public class CountLRUCacheMisses {


	public int lruCacheMisses(List<Integer> pages, int maxCacheSize){
		int ans = 0;
		LinkedList<Integer> list = new LinkedList<>();
		Set<Integer> set = new HashSet<>();

		for(int p: pages){
			if(set.contains(p)){
				list.removeFirstOccurrence(p);
			}else{
				if(list.size() == maxCacheSize){
					set.remove(list.removeFirst());
				}
				set.add(p);
				ans++;
			}
			list.addLast(p);
		}
		System.out.println(ans);
		return ans;
	}


	public static void main(String[] args){
		CountLRUCacheMisses app = new CountLRUCacheMisses();
		assert app.lruCacheMisses(Arrays.asList(1, 2, 1, 3, 1, 2), 2) == 4;
		assert app.lruCacheMisses(Arrays.asList(7, 6, 3, 4, 1, 1, 2, 0), 2) == 7;
	}
}

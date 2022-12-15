package com.xue.amazon;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChooseAFlask {
	int choose(int[] requirements, int[][] markings){
		Map<Integer, TreeSet<Integer>> flasks = new TreeMap<>();

		for(int[] m: markings){
			int type = m[0];
			flasks.putIfAbsent(type, new TreeSet<>());
			flasks.get(type).add(m[1]);
		}

		System.out.println(flasks);

		int min = Integer.MAX_VALUE;
		int ans = 0;

		tooSmall:
		for(Map.Entry<Integer, TreeSet<Integer>> e: flasks.entrySet()){
			TreeSet<Integer> marks = e.getValue();
			int waste = 0;
			for(int r: requirements){
				Integer mark = marks.ceiling(r);
				if(mark == null){
					System.out.println(e.getKey() + " too small");
					continue tooSmall;
				}
				waste += mark - r;
			}
			if(min > waste){
				min = waste;
				ans = e.getKey();
				System.out.println(e.getKey() + " waste " + min);
			}
		}

		return ans;
	}

	public static void main(String[] args){
		ChooseAFlask app = new ChooseAFlask();

		assert app.choose(new int[]{4, 6, 6, 7}, new int[][]{{0, 3}, {0, 5}, {0, 7}, {1, 6}, {1, 8}, {1, 9}, {2, 3}, {2, 5}, {2, 6}}) == 0;
		assert app.choose(new int[]{4, 6, 6, 7}, new int[][]{{1, 3}, {1, 5}, {1, 7}, {3, 6}, {3, 8}, {3, 9}, {2, 3}, {2, 5}, {2, 6}}) == 1;
		assert app.choose(new int[]{4, 6, 6, 7}, new int[][]{{3, 3}, {3, 5}, {3, 7}, {1, 6}, {1, 8}, {1, 9}, {2, 3}, {2, 5}, {2, 6}}) == 1;
		assert app.choose(new int[]{10}, new int[][]{{0, 10}, {1, 9}, {2, 11}}) == 0;
		assert app.choose(new int[]{5, 10}, new int[][]{{0, 4}, {0, 6}, {1, 9}, {1, 11}, {2, 5}, {2, 10}}) == 2;
	}
}

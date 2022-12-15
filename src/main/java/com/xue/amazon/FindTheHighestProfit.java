package com.xue.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Find The Highest Profit
public class FindTheHighestProfit {
	public static int supplierInventory1(int[] inventory, int order){
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int ret = 0;
		for(int j: inventory){
			pq.add(j);
		}

		while(order > 0 && !pq.isEmpty()){
			int tmp = pq.poll();
			ret += tmp;
			tmp--;
			order--;
			pq.add(tmp);
		}
		System.out.println(ret);
		return ret;
	}

	public static int supplierInventory(int[] inventory, int order){
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int ans = 0;
		for(int i: inventory){
			map.put(i, map.getOrDefault(i, 0) + 1);
			if(max < i)
				max = i;
		}

		while(order > 0 && !map.isEmpty()){
			int count = map.get(max);
			if(order > count){
				ans += count * max;
				order -= count;
				map.remove(max);
				max--;
				if(map.containsKey(max))
					map.put(max, map.get(max) + count);
				else
					map.put(max, count);
			}else{
				ans += max * order;
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args){
		assert supplierInventory(new int[]{3, 5}, 6) == 19;
		assert supplierInventory(new int[]{3, 5, 7, 10, 6}, 20) == 107;
	}
}

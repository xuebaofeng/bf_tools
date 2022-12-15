package com.xue.amazon;

import java.util.PriorityQueue;

public class ConnectRopes {
	public int connectRopes(int[] ropes){
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i: ropes){
			q.offer(i);
		}
		int ans = 0;
		while(!q.isEmpty()){
			int first = q.poll();
			if(q.isEmpty()){
				break;
			}
			int next = q.poll();
			int cost = first + next;
			ans += cost;
			q.offer(cost);
		}

		return ans;
	}
}

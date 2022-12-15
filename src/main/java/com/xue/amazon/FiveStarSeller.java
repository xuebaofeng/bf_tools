package com.xue.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FiveStarSeller {
	public int fiveStarReviews(int[][] products, int threshold){
		int n = products.length;
		double percent = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] / a[1]));

		for(int[] p: products){
			percent += p[0] * 1.0 / p[1];
			q.offer(p);
		}

		int ret = 0;
		while(percent / n * 100 < threshold){
			int[] p = q.poll();
			System.out.println(Arrays.toString(p));
			ret++;
			percent = percent - p[0] * 1.0 / p[1] + (p[0] + 1) * 1.0 / (p[1] + 1);
			p[0]++;
			p[1]++;
			q.offer(p);
		}
		System.out.println(ret);
		return ret;
	}


	public static void main(String[] args){
		FiveStarSeller obj = new FiveStarSeller();
		assert (obj.fiveStarReviews(new int[][]{{1, 2}}, 99) == 98);
		assert (obj.fiveStarReviews(new int[][]{{4, 4}, {1, 2}, {3, 6}}, 77) == 3);
		assert (obj.fiveStarReviews(new int[][]{{4, 4}, {1, 2}, {3, 6}}, 90) == 17);
	}
}

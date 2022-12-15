package com.xue.amazon;

import java.util.Arrays;
import java.util.Collections;

//Earliest Time To Complete Deliveries
public class EarliestTimeToCompleteDeliveries {
	int time(int[] open, Integer[] deliver){
		Arrays.sort(open);
		Arrays.sort(deliver, Collections.reverseOrder());
		int ans = 0;
		int j = 0;
		for(int i = 0; i < deliver.length; i++){
			if(i > 0 && i % 4 == 0){
				j++;
				j %= open.length;
			}
			System.out.println(i + "," + j);
			ans = Math.max(ans, deliver[i] + open[j]);
		}
		return ans;
	}

	public static void main(String[] args){
		EarliestTimeToCompleteDeliveries app = new EarliestTimeToCompleteDeliveries();
		assert app.time(new int[]{7, 9}, new Integer[]{7, 6, 3, 4, 1, 1, 2, 0}) == 14;
		assert app.time(new int[]{7, 9}, new Integer[]{7, 6, 3, 4, 1, 1, 2, 0, 3}) == 14;
		assert app.time(new int[]{8, 10}, new Integer[]{2, 2, 3, 1, 8, 7, 4, 5}) == 16;
		assert app.time(new int[]{8, 10}, new Integer[]{2, 2, 3, 1, 8, 7, 4, 5, 6}) == 16;
	}
}

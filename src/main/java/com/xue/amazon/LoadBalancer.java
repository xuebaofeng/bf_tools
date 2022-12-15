package com.xue.amazon;

public class LoadBalancer {

	public boolean loadBalance(int[] arr){
		if(arr.length < 5)
			return false;
		int leftsum = arr[0], rightsum = arr[arr.length - 1];
		int left = 1, right = arr.length - 2;

		while(left < right){
			if(leftsum == rightsum){
				int mid = left + 1;
				int sum = 0;
				while(mid < right){
					sum += arr[mid++];
				}
				if(sum == leftsum)
					return true;
			}

			if(leftsum < rightsum){
				leftsum += arr[left++];
			}else{
				rightsum += arr[right--];
			}
		}
		return false;
	}
}

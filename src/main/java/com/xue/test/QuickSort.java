package com.xue.test;

import java.util.Arrays;

public class QuickSort {
	public int[] sortArray(int[] nums){
		qsort(nums, 0, nums.length - 1);
		return nums;
	}

	void qsort(int[] nums, int lo, int hi){
		if(lo >= hi) return;
		int p = partition(nums, lo, hi);
		qsort(nums, lo, p - 1);
		qsort(nums, p + 1, hi);
	}

	int partition(int[] nums, int lo, int hi){
		int p = nums[lo];
		while(lo < hi){
			while(lo < hi && nums[hi] > p) hi--;
			nums[lo] = nums[hi];
			while(lo < hi && nums[lo] <= p) lo++;
			nums[hi] = nums[lo];
		}
		nums[lo] = p;
		return lo;
	}

	public static void main(String[] args){
		QuickSort q = new QuickSort();
		int[] array = q.sortArray(new int[]{5, 2, 3, 1});
		System.out.println(Arrays.toString(array));
	}


	private static void swap(int n[], int i, int j){
		int temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}

}
package com.xue.test;

import java.util.Arrays;

public class InsertionSort {
	public int[] sortArray(int[] nums){
		insertionSort(nums);
		return nums;
	}

	void insertionSort(int[] array){
		if(array == null || array.length < 2){
			return;
		}
		for(int i = 1; i < array.length; i++){
			for(int j = i; j > 0; j--){
				if(array[j] >= array[j - 1])
					break;
				array[j] ^= array[j - 1];
				array[j - 1] ^= array[j];
				array[j] ^= array[j - 1];
			}
		}
	}

	public static void main(String[] args){
		InsertionSort q = new InsertionSort();
		int[] array = q.sortArray(new int[]{5, 2, 3, 1});
		System.out.println(Arrays.toString(array));
	}
}
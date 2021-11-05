package com.xue.test;

import java.util.Arrays;

public class MergeSort {
	public int[] sortArray(int[] nums){
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	void mergeSort(int[] array, int left, int right){
		if(left == right){
			return;
		}
		int mid = left + ((right - left) >> 1);
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	void merge(int[] array, int left, int mid, int right){
		int[] temp = new int[right - left + 1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		while(p1 <= mid && p2 <= right){
			temp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
		}
		while(p1 <= mid){
			temp[i++] = array[p1++];
		}
		while(p2 <= right){
			temp[i++] = array[p2++];
		}
		for(i = 0; i < temp.length; i++){
			array[left + i] = temp[i];
		}
	}

	public static void main(String[] args){
		MergeSort q = new MergeSort();
		int[] array = q.sortArray(new int[]{5, 2, 3, 1});
		System.out.println(Arrays.toString(array));
	}

}
package com.xue.test;

import java.util.Arrays;
import java.util.Stack;

public class Test {

	public int sumSubarrayMins(int[] arr){
		System.out.println(Arrays.toString(arr));
		Stack<Integer> stack = new Stack();
		int n = arr.length;
		long ans = 0;
		for(int i = 0; i <= n; i++){
			while(!stack.isEmpty() && arr[stack.peek()] > (i == n ? 0 : arr[i])){
				int peak = stack.pop();
				int less = stack.isEmpty() ? -1 : stack.peek();
				System.out.println(String.format("i %s, arr[peak] %s, peak - less %s", i, arr[peak], peak - less));
				ans = (ans + 1L * arr[peak] * (i - peak) * (peak - less)) % 1000000007;
			}
			stack.push(i);
		}
		return (int)ans;
	}


	static void swap(char[] arr, int i, int j){
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}

	public static void main(String[] args){
		Test t = new Test();
//		System.out.println(t.expressiveWords("aaa",new String[]{"aaaa"}));
		System.out.println(t.sumSubarrayMins(new int[]{3, 1, 2, 4}));
	}

	public static void print2D(int mat[][], int i, int j){
		for(int k = 0; k < mat.length; k++){
			int[] row = mat[k];
			for(int l = 0; l < row.length; l++){
				if(k == i && j == l){
					System.out.print("*");
				}
				System.out.print(mat[k][l]);
				System.out.print(",");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(){
	}

	TreeNode(int val){
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

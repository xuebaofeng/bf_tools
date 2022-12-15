package com.xue.amazon;

public class ItemsInContainers {
	static int items(String s, int[] startIndices, int[] endIndices){
		int ans = 0;
		int left = startIndices[0] - 1;
		int n = s.length();
		while(left < n && s.charAt(left) == '*')
			left++;
		int right = endIndices[0] - 1;
		while(right >= 0 && s.charAt(right) == '*')
			right--;

		System.out.println("'" + s.substring(left, right + 1) + "'");

		if(left >= right)
			return 0;

		while(left < right){
			if(s.charAt(left) == '*')
				ans++;
			left++;
		}
		return ans;
	}

	public static void main(String[] args){
		assert items("*|*|", new int[]{1}, new int[]{3}) == 0;
		assert items("*|*|*|", new int[]{1}, new int[]{6}) == 2;
	}
}

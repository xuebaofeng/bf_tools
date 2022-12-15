package com.xue.amazon;

import java.util.ArrayList;
import java.util.List;

public class FindSubstrings {
	public static List<String> findSubstrings(String input){

		List<String> ans = new ArrayList<>();

		int[][] intervals = new int[26][2];
		for(int i = 0; i < 26; i++){
			intervals[i][0] = -1;
		}
		for(int i = 0; i < input.length(); i++){
			int[] a = intervals[input.charAt(i) - 'a'];
			if(a[0] == -1)
				a[0] = i;
			a[1] = i;
		}

		for(int[] a: intervals){
			if(a[0] == -1) continue;
			int len = a[1] - a[0];
			if(len < 2){
				String str = String.valueOf(input.charAt(a[0]));
				if(len == 1)
					str += input.charAt(a[0]);
				ans.add(str);
				continue;
			}
			int j = a[0] + 1;
			for(; j < a[1]; j++){
				if(j > input.length() - 1)
					break;
				int[] b = intervals[input.charAt(j) - 'a'];
				if(b[0] < j)
					break;
				if(b[1] != b[0] + len)
					break;
			}
			if(j == a[1]){
				String sub = input.substring(a[0], a[1]);
				ans.add(sub + sub);
			}
		}

		if(ans.isEmpty()){
			ans.add(input);
		}
		return ans;
	}

	public static void main(String[] args){
		assert findSubstrings("xyxy").get(0).equals("xyxy");
		assert findSubstrings("bacbacxyxyb").get(0).equals("xyxy");
		assert findSubstrings("bacbxzecvacbxzecvb").get(0).equals("bacbxzecvacbxzecvb");
	}
}

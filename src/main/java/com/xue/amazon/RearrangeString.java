package com.xue.amazon;

import java.util.Arrays;

public class RearrangeString {
	public static String rearrangeString(String str, int k){
		if(k == 0) return str;
		int[][] counter = new int[128][2];
		int max = 0;
		int same = 1;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			counter[c][0]++;
			counter[c][1] = c;
			int oneCount = counter[c][0];
			if(max < oneCount){
				max = oneCount;
				same = 1;
			}else if(max == oneCount){
				same++;
			}
		}
		if((max - 1) * k + same > str.length())
			return "";

		Arrays.sort(counter, (a, b) -> b[0] - a[0]);
		char[] ans = new char[str.length()];
		for(int[] c: counter){
			if(c[0] == 0) continue;
			int insert = 0;
			while(insert < ans.length && ans[insert] != 0)
				insert++;

			while(c[0] > 0){
				ans[insert] = (char)c[1];
				insert += k;
				c[0]--;
			}
		}
		System.out.println(ans);
		return new String(ans);
	}

	public static void main(String[] args){
		assert rearrangeString("a b c d e", 2).equals(" a b c de");
		assert rearrangeString("aabbcc", 3).equals("abcabc");
		assert rearrangeString("akaka", 2).equals("akaka");
	}
}

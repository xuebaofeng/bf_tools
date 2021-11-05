package sap;

import java.util.ArrayList;
import java.util.List;

public class Tester {
	public static void main(String[] args){
		Tester t = new Tester();

		Object o = t.canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}});
		//[true,false,false,true,true]
		System.out.println(o);
	}

	public List<Boolean> canMakePaliQueries(String s, int[][] queries){
		int[] counter = new int[s.length() + 1];
		for(int i = 0; i < s.length(); i++){
			counter[i + 1] = counter[i] ^ (1 << (s.charAt(i) - 'a'));
		}
		List<Boolean> ans = new ArrayList<>();
		for(int[] q: queries){
			int right = q[1] + 1;
			int left = q[0];
			String leftStr = Integer.toBinaryString(counter[left]);
			String rightStr = Integer.toBinaryString(counter[right]);
			String xorStr = Integer.toBinaryString(counter[right] ^ counter[left]);
			int count = Integer.bitCount(counter[right] ^ counter[left]);
			ans.add(count / 2 <= q[2]);
		}
		return ans;
	}
}

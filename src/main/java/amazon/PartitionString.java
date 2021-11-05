package amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {
	public static List<String> partitionString(String input){
		List<String> ans = new ArrayList<>();

		int[] last = new int[26];

		for(int i = 0; i < input.length(); i++){
			last[input.charAt(i) - 'a'] = i;
		}

		int start = 0, end = 0;

		for(int i = 0; i < input.length(); i++){
			end = Math.max(end, last[input.charAt(i) - 'a']);
			if(end == i){
				ans.add(input.substring(start, end + 1));
				start = end + 1;
			}
		}

		return ans;
	}
}

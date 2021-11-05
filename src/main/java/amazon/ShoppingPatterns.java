package amazon;

import java.util.*;

public class ShoppingPatterns {
	int min(int[] from, int[] to){
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i = 0; i < from.length; i++){
			int f = from[i];
			int t = to[i];
			map.putIfAbsent(f, new HashSet<>());
			map.putIfAbsent(t, new HashSet<>());
			map.get(f).add(t);
			map.get(t).add(f);
		}
		Set<String> uni = new HashSet<>();

		for(int a = 1; a <= from.length; a++){
			Set<Integer> bs = map.get(a);
			if(bs == null || bs.size() < 2) continue;
			for(int b: bs){
				Set<Integer> cs = map.get(b);
				if(cs == null || cs.size() < 2) continue;
				for(int c: cs){
					if(map.get(c).contains(a)){
						List<Integer> list = new ArrayList<>();
						list.add(a);
						list.add(b);
						list.add(c);
						Collections.sort(list);
						uni.add(list.get(0) + "," + list.get(1) + "," + list.get(2));
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(String s: uni){
			String[] abc = s.split(",");
			int a = Integer.parseInt(abc[0]);
			int b = Integer.parseInt(abc[1]);
			int c = Integer.parseInt(abc[2]);
			int count = map.get(a).size() + map.get(b).size() + map.get(c).size() - 6;
			ans = Math.min(ans, count);
		}

		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args){
		ShoppingPatterns s = new ShoppingPatterns();
		assert s.min(new int[]{1, 2, 2, 3, 4, 5}, new int[]{2, 4, 5, 5, 5, 6}) == 3;
		assert s.min(new int[]{1, 1, 2, 2, 3, 4}, new int[]{2, 3, 3, 4, 4, 5}) == 2;
	}
}

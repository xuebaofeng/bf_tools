package com.xue.amazon;

import java.util.*;

public class FindRelatedProducts {


	public List<String> findLargestGroup(List<List<String>> items){

		Map<String, Set<String>> graph = new HashMap<>();
		for(List<String> row: items){
			for(int i = 1; i < row.size(); i++){
				String a = row.get(i);
				String b = row.get(i - 1);
				graph.putIfAbsent(a, new HashSet<>());
				graph.putIfAbsent(b, new HashSet<>());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
		}

		Set<String> visited = new HashSet<>();
		Set<String> ans = new HashSet<>();

		for(String p: graph.keySet()){
			Set<String> candi = new HashSet<>();
			dfs(p, graph, visited, candi);
			if(candi.size() > ans.size())
				ans = candi;
		}
		return new ArrayList<>(ans);
	}

	private static void dfs(String p, Map<String, Set<String>> graph, Set<String> visited, Set<String> oneGroup){
		if(visited.contains(p))
			return;
		visited.add(p);
		oneGroup.add(p);
		for(String neib: graph.get(p)){
			dfs(neib, graph, visited, oneGroup);
		}
	}

	public static void main(String[] args){
		FindRelatedProducts app = new FindRelatedProducts();
		assert app.findLargestGroup(Arrays.asList(Arrays.asList("product1", "product2"), Arrays.asList("product3", "product2"), Arrays.asList("product5", "product6"))).size() == 3;
		assert app.findLargestGroup(Arrays.asList(Arrays.asList("product1", "product2"), Arrays.asList("product3", "product4"), Arrays.asList("product5", "product6"), Arrays.asList("product1", "product3", "product5"))).size() == 6;
	}
}

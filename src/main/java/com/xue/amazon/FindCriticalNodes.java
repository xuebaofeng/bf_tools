package com.xue.amazon;

import java.util.*;

public class FindCriticalNodes {
	public int[] findCriticalNodes(int numNodes, int[][] edges){
		if(numNodes == 1)
			return new int[]{};

		//construct graph
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		//initialize graph
		for(int i = 0; i < numNodes; i++)
			graph.put(i, new HashSet<>());

		//add edges to graph
		for(int[] edge: edges){
			int u = edge[0];
			int v = edge[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		List<Integer> result = new ArrayList<>();

		//calculate critical routers
		for(int i = 0; i < numNodes; i++){

			//remove each node and its edges and check if entire graph is connected
			Set<Integer> nodeEdges = graph.get(i);
			int lastNeib = 0;
			for(int edge: nodeEdges){
				graph.get(edge).remove(i);
				lastNeib = edge;
			}

			HashSet<Integer> visited = new HashSet<>();
			dfs(graph, lastNeib, visited);

			if(visited.size() != numNodes - 1){
				//this node was a critical router
				result.add(i);
			}

			//add the edges back
			for(int edge: nodeEdges)
				graph.get(edge).add(i);
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public void dfs(Map<Integer, Set<Integer>> graph, int source, Set<Integer> visited){
		if(visited.contains(source)) return;
		visited.add(source);
		for(int child: graph.get(source))
			dfs(graph, child, visited);
	}
}

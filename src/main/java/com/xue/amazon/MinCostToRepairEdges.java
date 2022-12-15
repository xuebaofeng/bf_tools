package com.xue.amazon;

import java.util.Arrays;
import java.util.Comparator;

//Min Cost to Repair Edges
public class MinCostToRepairEdges {
	public int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair){
		if(n == 0)
			return -1;

		if(edges.length == 0 && edgesToRepair.length == 0)
			return -1;

		UnionFind uf = new UnionFind(n);
		for(int[] e: edges){
			uf.union(e[0], e[1]);
		}

		if(uf.count == 1)
			return 0;

		Arrays.sort(edgesToRepair, Comparator.comparingInt(a -> a[2]));


		int ans = 0;
		for(int[] c: edgesToRepair){
			if(!uf.connect(c[0], c[1])){
				uf.union(c[0], c[1]);
				ans += c[2];
				uf.union(c[0], c[1]);
				if(uf.count == 1){
					return ans;
				}
			}
		}
		return -1;
	}

	static class UnionFind {
		int count;
		int[] parent;

		UnionFind(int n){
			count = n;
			parent = new int[n + 1];
			for(int i = 0; i <= n; i++){
				parent[i] = i;
			}
		}

		boolean connect(int a, int b){
			return find(a) == find(b);
		}

		void union(int a, int b){
			int rootA = find(a);
			int rootB = find(b);
			if(rootA == rootB)
				return;
			parent[rootB] = rootA;
			count--;
		}

		int find(int a){
			if(parent[a] == a)
				return a;
			return parent[a] = find(parent[a]);
		}
	}
}


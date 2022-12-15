package com.xue.amazon;

import java.util.Arrays;
import java.util.Comparator;

//Min Cost To Add New Roads
public class MinCostToAddNewRoads {
	public int minCostConnectNodes(int n, int[][] connects){
		if(n == 0 || connects == null || connects.length == 1)
			return 0;

		Arrays.sort(connects, Comparator.comparingInt(a -> a[2]));

		UnionFind uf = new UnionFind(n);
		int ans = 0;
		for(int[] c: connects){
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

	public static void main(String[] args){
		MinCostToAddNewRoads app = new MinCostToAddNewRoads();
		assert app.minCostConnectNodes(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}) == 6;
		assert app.minCostConnectNodes(4, new int[][]{{1, 2, 4}, {3, 4, 4}}) == -1;
	}
}


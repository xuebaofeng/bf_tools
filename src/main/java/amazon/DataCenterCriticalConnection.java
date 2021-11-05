package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataCenterCriticalConnection {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer>[] graph;
	int[] low;
	int[] ids;
	int id;

	public List<List<Integer>> findCriticalConn(int serversNum, int connectionsNum, int[][] connections){
		int n = serversNum;

		graph = new List[n + 1];
		low = new int[n + 1];
		ids = new int[n + 1];
		Arrays.fill(ids, -1);

		for(int i = 0; i <= n; i++){
			graph[i] = new ArrayList<>();
		}

		for(int[] e: connections){
			int a = e[0];
			int b = e[1];
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1, -1);
		return ans;
	}

	void dfs(int u, int parent){
		low[u] = ids[u] = ++id;
		for(int v: graph[u]){
			if(v == parent) continue;
			if(ids[v] == -1){
				dfs(v, u);
				low[u] = Math.min(low[u], low[v]);
				if(ids[u] < low[v])
					ans.add(Arrays.asList(u, v));
			}else{
				low[u] = Math.min(low[u], low[v]);
			}
		}
	}
}

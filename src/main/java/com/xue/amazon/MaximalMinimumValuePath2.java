package com.xue.amazon;

import java.util.PriorityQueue;

public class MaximalMinimumValuePath2 {

	public int maxPathScore(int[][] matrix){

		int m = matrix.length;
		int n = matrix[0].length;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

		queue.add(new int[]{matrix[0][0], 0, 0, matrix[0][0]});

		int[] dr = new int[]{1, 0, -1, 0};
		int[] dc = new int[]{0, -1, 0, 1};
		boolean[][] seen = new boolean[m][n];
		seen[0][0] = true;

		while(!queue.isEmpty()){
			int[] e = queue.poll();
			if(e[1] == m - 1 && e[2] == n - 1) return e[3];

			for(int i = 0; i < 4; i++){
				int r = e[1] + dr[i];
				int c = e[2] + dc[i];
				if(r >= 0 && r < m && c >= 0 && c < n && !seen[r][c]){
					queue.add(new int[]{matrix[r][c], r, c, Math.min(matrix[r][c], e[3])});
					seen[r][c] = true;
				}
			}
		}
		return -1;
	}
}

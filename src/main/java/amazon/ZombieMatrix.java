package amazon;

import java.util.LinkedList;
import java.util.Queue;

//Zombie Matrix
public class ZombieMatrix {

	public static int humanDays(int[][] matrix){
		int ans = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();

		int count = 0;
		int total = m * n;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1){
					q.offer(new int[]{i, j});
					count++;
				}
			}
		}
		int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1},};
		while(!q.isEmpty()){
			if(count == total)
				return ans;
			int size = q.size();
			for(int i = 0; i < size; i++){
				int[] cell = q.poll();
				for(int[] dir: dirs){
					int r = cell[0] + dir[0];
					int c = cell[1] + dir[1];
					if(r < 0 || c < 0 || r == m || c == n || matrix[r][c] == 1){
						continue;
					}
					q.offer(new int[]{r, c});
					count++;
					matrix[r][c] = 1;
				}
			}
			ans++;
		}
		return -1;
	}

	public static void main(String[] args){
		assert humanDays(new int[][]{{1}, {1}, {1}, {1}}) == 0;
		assert humanDays(new int[][]{{1, 0}}) == 1;
	}
}

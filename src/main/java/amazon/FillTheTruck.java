package amazon;

import java.util.Collections;
import java.util.PriorityQueue;

//Fill The Truck
public class FillTheTruck {
	public int fillTheTruck1(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize){
		int cnt = 0;

		PriorityQueue<Integer> unitsMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		// for each product
		for(int i = 0; i < num; i++){
			// for each box count
			for(int j = 0; j < boxes[i]; j++){
				unitsMaxHeap.add(unitsPerBox[i]);
			}
		}

		while(truckSize > 0 && !unitsMaxHeap.isEmpty()){
			int units = unitsMaxHeap.poll(); // get max units count
			cnt += (long)units;
			truckSize--;
		}

		return cnt;
	}

	public int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize){

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for(int i = 0; i < num; i++){
			q.offer(new int[]{boxes[i], unitsPerBox[i]});
		}
		int ans = 0;
		while(!q.isEmpty() && truckSize > 0){
			int[] e = q.poll();
			ans += Math.min(truckSize, e[0]) * e[1];
			truckSize -= e[0];
		}
		return ans;
	}
}

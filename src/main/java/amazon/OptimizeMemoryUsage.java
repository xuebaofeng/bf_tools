package amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimizeMemoryUsage {

	public static List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K){
		List<int[]> result = new ArrayList<>();
		if(K == 0 || (foregroundTasks.length == 0 && backgroundTasks.length == 0))
			result.add(new int[]{-1, -1});

		List<int[]> fList = new ArrayList<>();
		List<int[]> bList = new ArrayList<>();

		for(int i = 0; i < foregroundTasks.length; i++){
			fList.add(new int[]{i, foregroundTasks[i]});
		}

		for(int i = 0; i < backgroundTasks.length; i++){
			bList.add(new int[]{i, backgroundTasks[i]});
		}

		fList.sort(Comparator.comparingInt(p -> p[1]));
		bList.sort(Comparator.comparingInt(p -> p[1]));

		int max = Integer.MIN_VALUE;
		for(int i = 0; i < foregroundTasks.length; i++){
			int a = fList.get(i)[1];
			if(a == K){
				result.add(new int[]{fList.get(i)[0], -1});
				max = a;
			}
		}

		for(int i = backgroundTasks.length - 1; i >= 0; i--){
			int b = bList.get(i)[1];
			if(b == K){
				result.add(new int[]{-1, bList.get(i)[0]});
				max = b;
			}
		}

		if(foregroundTasks.length > 0 && backgroundTasks.length == 0){
			for(int i = 0; i < foregroundTasks.length; i++){
				if(fList.get(i)[1] < K){
					result.add(new int[]{fList.get(i)[0], -1});
				}
			}

			return result;
		}

		if(backgroundTasks.length > 0 && foregroundTasks.length == 0){
			for(int i = backgroundTasks.length - 1; i >= 0; i--){
				if(bList.get(i)[1] < K){
					result.add(new int[]{-1, bList.get(i)[0]});
				}
			}

			return result;
		}

		int i = 0;
		int j = backgroundTasks.length - 1;
		while(i < foregroundTasks.length && j >= 0){
			int sum = fList.get(i)[1] + bList.get(j)[1];

			if(sum > K){
				j = j - 1;
			}else{
				if(max <= sum){
					if(max < sum){
						max = sum;
						result.clear();
					}
					result.add(new int[]{fList.get(i)[0], bList.get(j)[0]});
					int index = j - 1;
					while(index >= 0 && bList.get(index)[1] == bList.get(index + 1)[1]){
						result.add(new int[]{fList.get(i)[0], bList.get(index)[0]});
						index--;
					}
				}
				++i;
			}
		}

		return result;
	}

	// 1 7 8
	// 1 2 3
	public static void main(String[] args){
		assert optimizeMemoryUsage(new int[]{1, 1}, new int[]{6, 6, 6, 6, 7}, 7).size() == 9;
		assert optimizeMemoryUsage(new int[]{1, 7, 2, 4, 5, 6}, new int[]{1, 1, 2}, 10).size() == 1;
	}
}

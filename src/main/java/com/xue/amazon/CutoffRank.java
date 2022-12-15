package com.xue.amazon;

public class CutoffRank {

	public int cutOffRank(int cutOffRank, int num, int[] scores){
		int[] counter = new int[101];
		for(int i: scores){
			counter[i]++;
		}

		int rank = 1;
		for(int i = 100; i >= 0 && rank <= cutOffRank; i--){
			int count = counter[i];
			if(count == 0) continue;
			rank += count;
		}
		return rank - 1;
	}
}

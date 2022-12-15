package com.xue.amazon;

public class ThrottlingGateway {

	public static void main(String[] args){
		assert throttlingGateway(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11}) == 7;
		assert throttlingGateway(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11}) == 1;
		assert throttlingGateway(new int[]{1, 1, 1, 1, 2}) == 1;
		assert throttlingGateway(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7}) == 2;
	}

	static int throttlingGateway(int[] arriveTime){
		int ans = 0;
		for(int i = 0; i < arriveTime.length; i++){
			if((i >= 3) && arriveTime[i] - arriveTime[i - 3] < 1){
				ans++;
			}else if((i >= 20) && (arriveTime[i] - arriveTime[i - 20]) < 10){
				ans++;
			}else if((i >= 60) && (arriveTime[i] - arriveTime[i - 60]) < 60){
				ans++;
			}
		}
		System.out.println(ans);
		return ans;
	}
}

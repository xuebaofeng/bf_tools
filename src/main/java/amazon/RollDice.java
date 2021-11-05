package amazon;

/*
 * https://aonecode.com/amazon-online-assessment-questions#dl
 */
public class RollDice {

	public int getMinimumRolls(int[] A){

		int len = A.length;
		if(len <= 1) return 0;

		int[] selfCount = new int[6];
		int[] opposites = new int[6];

		for(int i: A){
			selfCount[i - 1]++;
			opposites[7 - i - 1]++;
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++){
			if(selfCount[i] == 0) continue;

			int rolls = len - selfCount[i] + opposites[i];
			min = Math.min(min, rolls);
		}
		return min;
	}

	public static void main(String[] args){

		RollDice app = new RollDice();
		assert app.getMinimumRolls(new int[]{6, 5, 4}) == 2;
		assert app.getMinimumRolls(new int[]{6, 6, 1}) == 2;
		assert app.getMinimumRolls(new int[]{6, 1, 5, 4}) == 3;
	}
}

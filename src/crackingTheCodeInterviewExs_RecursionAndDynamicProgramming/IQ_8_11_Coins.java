package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

public class IQ_8_11_Coins {

	public static void main(String[] args) {
	}

	// e.g. amount = 100
	int makeChange(int amount, int[] denoms, int index) {
		if (index >= denoms.length - 1) return 1; // last denom
		int denomAmount = denoms[index]; // 25, 10, 5, 1
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1);
		}
		return ways;
	}
	
	int makeChange(int n) {
		int[] denoms = {25, 10, 5, 1};
		return makeChange(n, denoms, 0);
	}
	
	int makeChangeOptimal(int n) {
		int[] denoms = {25, 10, 5, 1};
		int[][] map = new int[n + 1][denoms.length]; // precomputed vals
		return makeChangeOptimal(n, denoms, 0, map);
	}
	
	int makeChangeOptimal(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) { // retrieve value
			return map[amount][index];
		}
		if (index >= denoms.length - 1) return 1; // one denom remaining
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			// go to next denom, assuming i coins of denomAmount
			int amountRemaining = amount - i * denomAmount;
			ways += makeChangeOptimal(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
}

package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

import java.util.Arrays;

public class IQ_8_1_TripleStep {
	
	// Simple implementation
	int countWays(int n) { // n = 2
		if (n < 0) {
			return 0;
		} else if ( n == 0) {
			return 1;
		} else {
			//n=2	countWays(1)			countWays(0)
			//n=1	countWays(0)			+ 1
			//n=0	+ 1
			return countWays(n - 1) + countWays(n - 2) + countWays(n-3);
		}
	}
	
	// Memoization solution
	int countWaysMemoization(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWaysMemoization(n,memo);
	}
	
	int countWaysMemoization(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) { // n is a positive integer
			return memo[n];
		} else {
			memo[n] = countWaysMemoization(n - 1, memo) 
					+ countWaysMemoization(n - 2, memo)
					+ countWaysMemoization(n - 3, memo);
			return memo[n];
		}
	}
}

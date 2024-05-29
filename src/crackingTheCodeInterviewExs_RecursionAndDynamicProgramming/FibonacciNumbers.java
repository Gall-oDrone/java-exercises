package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

public class FibonacciNumbers {

	int fibonacci(int i) {
		if (i == 0) return 0;
		if ( i == 1) return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
	
	// Recursive memoization
	int fibonacci_memo(int n) {
		return fibonacci_m(n, new int[n+1]);
	}

	int fibonacci_m(int i, int[] memo) {
		if (i == 0 || i == 1) return i;
		
		if(memo[i] == 0) {
			memo[i] = fibonacci_m(i -1, memo) + fibonacci_m(i - 2, memo);
		}
		return memo[i];
	}
	
	// Bottom-Up Dynamic Programming
	int fibonacci_bu(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i + 2];
		}
		return memo[n - 1] + memo[n - 2];
	}
	
	// Bottom-Up Dynamic Programming v2
		int fibonacci_bu_v2(int n) {
			if (n == 0) return 0;
			int a = 0;
			int b = 1;
			for (int i = 2; i < n; i++) {
				// i = {2,3}
				int c = a + b; // {1,2,3,5,8,...}
				a = b; // {1,1,2,3,5,...}
				b = c; // {1,2,3,5,8,...}
			}
			return a + b;
		}
}

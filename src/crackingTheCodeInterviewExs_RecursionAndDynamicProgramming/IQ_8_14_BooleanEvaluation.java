package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

import java.util.HashMap;

public class IQ_8_14_BooleanEvaluation {

	public static void main(String[] args) {
	}
	
	/* 
	 * Brute force
	 */
	int countEval(String s, boolean result) {
		if (s.length() == 0) return 0;
		if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
		
		int ways = 0;
		for (int i = 1; i < s.length(); i+=2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i+1, s.length());
			
			/* Evaluate each side for each result. */
			int leftTrue = countEval(left, true);
			int leftFalse= countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
					totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}
			
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		
		return ways;
	}
	
	boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}

	/* Optimized solution #1 */
	int countEvalOptimized1(String s, boolean result, HashMap<String, Integer> memo) {
		if (s.length() == 0) return 0;
		if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
		if (memo.containsKey(result + s)) return memo.get(result + s);
		
		int ways = 0;
		
		for (int i = 1; i < s.length(); i+= 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			int leftTrue = countEvalOptimized1(left, true, memo);
			int leftFalse = countEvalOptimized1(left, false, memo);
			int rightTrue = countEvalOptimized1(right, true, memo);
			int rightFalse = countEvalOptimized1(right, false, memo);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
					totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}
			
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		
		memo.put(result + s, ways);
		return ways;
	}
}

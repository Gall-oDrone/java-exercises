package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class IQ_8_7_PermutationsWithoutDups {

	ArrayList<String> getPerms(String str) {
		if (str == null) return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0); // get the first char
		String remainder = str.substring(1); // remove the first char
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	/* Insert char c at index i in word. */
	String insertCharAt(String word, char c, int i) {
		String start = word.substring(0,i); // 0 a 1 = ¿ 'c' ?
		String end = word.substring(i); // 1 = ""
		return start + c + end;
	}
	
	// Approach 2: Building from permutations of all n-1 character substrings.
	// Base Case: single-character strings
	ArrayList<String> getPerms2(String remainder) {
		int len = remainder.length();
		ArrayList<String> result = new ArrayList<String>();
		
		/* Base case */
		if(len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}
		
		for (int i = 0; i < len; i++) {
			/* Remove char i and find permutations of remaining chars. */
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			ArrayList<String> partials = getPerms2(before + after);
			
			/* Prepend char i to each permutation.*/
			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}
		}
		return result;
	}
	
	ArrayList<String> getPerms3(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms3("", str, result);
		return result;
	}
	
	void getPerms3(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) result.add(prefix);
		
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, len);
			String after = remainder.substring(i+1, len);
			char c = remainder.charAt(i);
			getPerms3(prefix + c, before + after, result);
		}
	}
}

package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class IQ_1_2_CheckPermutation {
	
	public static void main(String[] args) {
		String str1 = "qewrtyu";
		String str2 = "uytrewq";
		System.out.println("Is '"+str1+ "' a permutation of '"+ str2+ "'? "+CheckPermutation(str1,str2));
		
	}
	
	public static boolean CheckConds(Integer cond, String str1, String str2, StringBuilder sb) {
		switch(cond) {
			case 1:
				return str1.length() == str2.length();
			case 2:
				return str1.length()>0 && str2.length()>0;
			case 3:
				return str1.length()>0 && sb.length()>0;
			default:
				return false;
		}
	}
	
	public static boolean CheckPermutation(String str1, String str2) {
		if(CheckConds(1,str1,str2,null)&&CheckConds(2,str1,str2,null)) {
			StringBuilder sb = new StringBuilder(str2);
			for(int i=0; i<=str1.length(); i++) {
				if(sb.length() == 0 && i ==str1.length()) {
					return true;
				}
				if(i==str1.length()) {
					break;
				}
				if(CheckConds(3,str1,str2,sb)) {
					InnerLoop(str1,sb,i);
				}
			}
		}
		return false;
	}
	
	public static void InnerLoop(String str1, StringBuilder sb, Integer i) {
		for(int j=0; j<sb.length();j++) {
			if(Character.toLowerCase(sb.charAt(j)) == Character.toLowerCase(str1.charAt(i))) {
				sb.deleteCharAt(j);
				return;
			}
		}
	}
	
	/* Solutions 
	 * Assuming case sensitive e.g. "god    " != "dog"
	 */
	/* Solution #1: Sort the strings */
	String sort(String s) {
		char[] content = s.toCharArray(); 
		Arrays.sort(content);
		return new String(content);
	}
	
	boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	/* Solution #2; Check if the two strings have identical charcter counts */
	boolean permutation3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128]; // Assumptions ASCII
		
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++; // duda?
		}
		
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}

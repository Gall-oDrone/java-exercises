package leetCodeExcercises1;

public class LC_ValidAnagram_242 {
	
	class Solution {
		public boolean isAnagram(String s, String t) {
			// If the lengths are different, they can't be anagrams
			if (s.length() != t.length()) {
				return false;
			}
			
			// Create an array to count character frequencies
			int[] charCounts = new int[26]; // assuming only lowercase English letters
			
			// Increment count for each character in 's' and decrement for each in 't'
			for (int i = 0; i < s.length(); i++) {
				charCounts[s.charAt(i) - 'a']++;
				charCounts[t.charAt(i) - 'a']--;
			}
			
			// Check if all counts are zero
			for (int count : charCounts) {
				if (count != 0) {
					return false;
				}
			}
			
			return true; // All counts are zero, so 't' is an anagram of 's'
		}
	}
}

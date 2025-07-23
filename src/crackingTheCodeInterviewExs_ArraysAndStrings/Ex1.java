package crackingTheCodeInterviewExs_ArraysAndStrings;
/* Asume characters are ASCII 128 unique characters
 256 extended unique characters 
 */
public class Ex1 {
	// each element in words is of length 'x'
	String joinWords(String[] words) {
		String sentence = "";
		for (String w: words) {
			sentence = sentence + w;
		}
		return sentence;
	}
	
	String joinWords2(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String w: words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	
	/* Solution */
	boolean isUniqueChars(String str) {
		if (str.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	/* Solution with space reduction */
	boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}

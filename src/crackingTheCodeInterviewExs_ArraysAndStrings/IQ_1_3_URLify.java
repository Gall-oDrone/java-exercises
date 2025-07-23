package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.lang.reflect.Array;

public class IQ_1_3_URLify {
	public static void main(String[] args) {
		String test = "Mr John Smith      ";
		Integer len = 13; 
		System.out.println("Output: "+URLify(test, len));
	}
	
	public static String URLify(String test, Integer len) {
		char[] c_arr = test.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i <= len) {
			if(i == len) {
				break;
			}
			char x =  Array.getChar(c_arr, i);
			if(x == ' ') {
				sb.append("%20");
			} else {
				sb.append(x);
			}
			i++;
		}
		return sb.toString();
	}
	
	/* Solutions */
	void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) str[trueLength] = '\0'; // End array
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index -1] = '0';
				str[index -2] = '2';
				str[index -3] = '%';
				index = index -3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
}

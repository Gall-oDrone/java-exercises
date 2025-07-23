package crackingTheCodeInterviewExs_ArraysAndStrings;

public class IQ_1_6_StringCompression {

	public static void main(String[] args) {
		String test = "aabcccccaaa";
		System.out.println("Output: "+ SringCompression(test));
	}
	
	public static String SringCompression(String str) {
		char[] ca = str.toCharArray();
		String oa = "";
		int cum = 0;
		rec1(ca, oa, cum);
		return oa;
		
	}
	
	public static void rec1(char[] carr, String oa, int cum) {
		if(carr.toString().isEmpty()) {return;}
		cum++;
		if(!oa.toLowerCase().contains(Character.toString(carr[0]).toLowerCase())) {
			oa = oa + String.valueOf(carr[0]);
			char[] csuba = carr.toString().substring(1).toCharArray();
			rec1(csuba, oa, cum);
		}
		if(oa.toLowerCase().contains(Character.toString(carr[0]).toLowerCase())&&
				!String.valueOf(carr[0]).toLowerCase().equals(String.valueOf(carr[1]).toLowerCase())) {
			oa = oa + String.valueOf(cum);
			cum = 0;
			char[] csuba = carr.toString().substring(1).toCharArray();
			rec1(csuba, oa, cum);
		}
		if(oa.toLowerCase().contains(Character.toString(carr[0]).toLowerCase())&&
				!String.valueOf(carr[0]).toLowerCase().equals(String.valueOf(carr[1]).toLowerCase())) {
			oa = oa + String.valueOf(cum);
			cum = 0;
			char[] csuba = carr.toString().substring(1).toCharArray();
			rec1(csuba, oa, cum);
		}
		
	}
	/* Solution */
	String compressBad(String str) {
		String compressedString = "";
		int countConsecutive  = 0;
		for (int i=0; i < str.length(); i++) {
			countConsecutive++;
			
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}
	
	String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i=0; i<str.length();i++) {
			countConsecutive++;
			if ( i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	String compress2(String str) {
		int finalLength = countCompression(str);
		if (finalLength >= str.length()) return str;
		
		StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
		int countConsecutive = 0;
		for (int i=0; i<str.length();i++) {
			countConsecutive++;
			if ( i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i=0; i<str.length(); i++) {
			countConsecutive++;
			
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

}

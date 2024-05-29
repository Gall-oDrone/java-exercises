package crackingTheCodeInterviewExs;

public class IQ_1_9_StringRotation {

	public static void main(String[] args) {
		String s1 = "erbottlewat";
		String s2 = "waterbottle";
		
		System.out.println("output: "+ isSubstring(s1,s2));

	}
	
	public static String toString(char[] a) {
		String string = String.valueOf(a);
		return string;
	}
	
	public static boolean isSubstring(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int n = ch1.length;
		String cum = "";
		int i=0,j = 0;
		while(i<n) {
			if(toString(ch1).equals(toString(ch2))) {
				break;
			}
			// TOIMPROVE
			if(ch1[i] == ch2[j]) {
				i++;
			}
			if(j+1==n) {
				j=0;
			}
			cum = Character.toString(ch2[j]);
			ch2[j] = ch2[j+1];
			ch2[j+1] = cum.charAt(0);
			j++;
			System.out.println("ch2 to string: "+toString(ch2));
		}
		System.out.println("Output: "+toString(ch2));
		return true;
	}
	
	/* Solution */
	boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/* Check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* Concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}
	

}

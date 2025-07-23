package crackingTheCodeInterviewExs_ArraysAndStrings;

public class IQ_1_5_OneAway {

	public static void main(String[] args) {
		String[] str_arr1 = new String[]{"pale","pales","pale","pale"};
		String[] str_arr2 = new String[] {"ple","pale","bale","bake"};
		System.out.println("Output: "+oneAway(str_arr1,str_arr2));
	}
	
	public static boolean oneAway(String[] s1, String[] s2) {
		for(int i=0;i<s1.length;i++) {
			for(int j=0;j<s2.length;j++) {
				int counter = 0;
				boolean out = false;
				rec1(s1[i],s2[j], counter, out);
				System.out.println("out: "+out);
				return out;
			}
		}
		return false;
	}
	
	public static boolean rec1(String sb1, String sb2, int counter, boolean out) {
		if((sb1.isEmpty() || sb2.isEmpty()) && counter >1) {out=false; return false;}
		if(sb1.isEmpty() && counter <=1) {out=true;System.out.println("out f: "+out);return true;}
		String ss1 = String.valueOf(sb1.charAt(0));
		String ss2 = String.valueOf(sb2.charAt(0));
		if(!ss1.equals(ss2)) {
			counter++;
			rec1(sb1.substring(1),sb2,counter,out);
		} else {
			rec1(sb1.substring(1),sb2.substring(1),counter,out);
		}
		return true;
	}
	
	/* Solution */
	boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i ++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	/* Check if you can insert a character into s1 to make s2 */
	boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
					index1++;
					index2++;
			}
			return true;
		}
	}
	
	boolean oneEditAway(String first, String second) {
		/* Length checks */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		/* Get shorter and longer string.*/
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s1.charAt(index2)) {
				if (foundDifference) return false;
				foundDifference = true;
			} else {
				index1++; // If matching, move shorter pointer
			}
			index2++; // Always move pointer for longer string
		}
		return true;
	}
}

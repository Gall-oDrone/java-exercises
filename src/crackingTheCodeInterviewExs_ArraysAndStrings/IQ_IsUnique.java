package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.util.ArrayList;

public class IQ_IsUnique {

	public static void main(String[] args) {
		String test = "qewrtyu";
		boolean is_unique = IsUnique(test);
		System.out.println("Is "+test+" a unique string?: "+ is_unique);
	}
	
	public static boolean IsUnique(String string) {
		long startTime = System.nanoTime();
		ArrayList<String> stringArr = new ArrayList<String>();
		boolean hasUnique = false;
		for(int i=0; i<string.length(); i++) {
			String val = String.valueOf(string.charAt(i));
			if(!stringArr.contains(val)) {
				hasUnique = true;
				break;
			} 
			stringArr.add(val);
		}
		long stopTime = System.nanoTime();
		System.out.println("elapsed time: "+ (stopTime-startTime)+" ns");
		return hasUnique;
	}

}

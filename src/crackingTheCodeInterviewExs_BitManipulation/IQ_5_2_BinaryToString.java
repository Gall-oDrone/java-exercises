package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_2_BinaryToString {
	public void BinaryToString(double r) {
		String s = String.valueOf(r);
		int n = s.length();
		boolean pd = false;
		for (int i = 0; i < n; i++) {
			if(s.charAt(i) == ".".charAt(0)) {
				pd = true;
			}
			if (pd) {
				int num = Integer.valueOf(s.substring(i, (n-1)));
				if(num % 25 != 0 || num % 4 == 0) {
					System.out.println("ERROR");
					return;
				} else {
					int l = num;
					int r = 0;
					while(l % 2) {}
				}
			}
		}
	}
	
	/* Solution */
	String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else  {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	/* Alternative apporach */
	String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}
}

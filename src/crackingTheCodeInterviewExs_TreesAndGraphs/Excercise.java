package crackingTheCodeInterviewExs_TreesAndGraphs;

import java.util.ArrayList;

public class Excercise {

	public static void solve(int num1, int num2) {
		double res = (double) num1 / num2;
		res = (double)Math.round(res * 10000d) / 10000d;
		String sres = String.valueOf(res);
		System.out.println("res: "+ res);
		ArrayList<Character> strcp = new ArrayList<Character>();
		int dc = 0; // digits counter
		int idx = sres.length() -1;
		while(idx >= 0) {
			char sc = sres.charAt(idx);
			char sp = ".".charAt(0);
			strcp.add(sc); 
			if (sc == sp) {
				int dl = 4 - dc;// decimals left
				if(dl > 0) {
					for(int i=0;i<dl;i++) {
						char z = "0".charAt(0); 
						strcp.add(0,z);
					}
				}
				dc = 0;
			}
			if(strcp.size() >= 6) {
				if(dc % 4 == 0) {
					char c = ",".charAt(0); 
					strcp.add(dc,c);
				}
			}
			dc++;
			idx--;
			
		}
		System.out.println("Output: "+ strcp);
	}
	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 3;
		solve(num1,num2);

	}

}

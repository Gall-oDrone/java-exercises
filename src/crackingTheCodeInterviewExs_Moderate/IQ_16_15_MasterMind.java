package crackingTheCodeInterviewExs_Moderate;

public class IQ_17_15_MasterMind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	class Result {
		public int hits = 0;
		public int pseudoHits = 0;
		
		public String toString() {
			return "(" + hits + ", " + pseudoHits + ")";
		}
	}
	
	int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	int MAX_COLORS = 4;
	
	Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) return null;
		
		Result res = new Result();
		int[] frequencies = new int[MAX_COLORS];
		
		/* Compute hits and build frequency table */
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits++;
			} else {
				/* Only increment the frequency table (which will be used for pseudo-hits)
				 * if it's not a hit. If it's a hit, the slot has already been "used." */
				int code = code(solution.charAt(i));
				frequencies[code]++;
			}
		}
		
		/* Compute pseudo-hits */
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequencies[code] > 0 && 
					guess.charAt(i) != solution.charAt(i)) {
				res.pseudoHits++;
				frequencies[code]--;
			}
		}
		return res;
	}
}

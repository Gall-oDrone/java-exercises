package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_6 {
	
	/*
	 * EXAMPLE Input 29 (11101), 15 (01111)
	 * OUTPUT 2
	 */
	int bitSwapREquired(int a, int b) {
		int count = 0;
		// ^ (XOR) = 0 ^ 1 = 1, 1 ^ 0 = 1
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	int bitSwapRequiredBetter(int a, int b) {
		int count = 0;
		/*
		 * c = 11101 ^ 01111 = 10010
		 */
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			/*
			 * c-1 = 10010 - 1 = 10001
			 * c & (c-1) = 10010 & 10001 = 10000
			 * c-1 = 10000 - 1 = 01111
			 * c & (c-1) = 10000 & 01111 = 00000
			 */
			count ++; // 1, 2
		}
		return count;
	}
}

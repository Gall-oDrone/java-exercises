package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_1_Insertion {
	public void Insertion(int i, int j, byte[] N, byte[] M) {
		if((j-i)>=5) {
			int idx = 0;
			for(int k=(((N.length)-j)-1); k< ((N.length)-i); k++) {
				N[k] = M[idx];
				idx++;
			}
		}
	}
	
	/* Solution */
	int updateBits(int n, int m, int i, int j) {
		/* Create a mask to clear bits i through j in n. EXAMPLE: i = 2, j = 4. Result
		 * should be 11100011. For simplicity, we'll use just 8 bits for the example. */
		
		int allOnes = ~0; // will equal sequence of all 1s
		
		// 1s before position j, then 0s. left = 11100000
		int left = allOnes << (j + 1);
		
		// 1's after position i. right = 00000011
		int right = ((1 << i) - 1);
		// All 1s, except for 0s between i and j. mask = 11100011
		int mask = left | right;
		
		/* Clear bits j through i then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		
		return n_cleared | m_shifted; // OR them, and we're done!
	}
}

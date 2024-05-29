package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_4_NextNumber {
	public void starter() {
		System.out.println(getNext(13948));
	}
	// The Brute Force Approach
	int getNext(int n) {
		/* Compute c0 and c1 */
		int c = n;
		int c0 = 0;
		int c1 = 0;
		/* n=13948 => c=11011001111100 
		 * 		    	     00000000000001 
		 *  c & 1 = 11011001111100 & 00000000000001 = 0000000000000 = 0
		 *  c & 1 = 11101100111110 & 00000000000001 = 0000000000000 = 0
		 *  c & 1 = 11110110011111 & 00000000000001 = 0000000000001 = 1
		 */
		while (((c & 1) == 0) && (c != 0)) {
			c0++; // 1,2
			c >>= 1; // 11101100111110,11110110011111
		}
		
		/*
		 * c & 1 = 11110110011111 & 00000000000001 = 0000000000001 = 1
		 * c & 1 = 11111011001111 & 00000000000001 = 0000000000001 = 1
		 * c & 1 = 11111101100111 & 00000000000001 = 0000000000001 = 1
		 * c & 1 = 11111110110011 & 00000000000001 = 0000000000001 = 1
		 * c & 1 = 11111111011001 & 00000000000001 = 0000000000001 = 1
		 * c & 1 = 11111111101100 & 00000000000001 = 0000000000000 = 0
		 */
		while ((c & 1) == 1) {
			c1++; // 1,2,3,4,5
			c >>= 1; // 11111011001111,11111101100111,11111110110011,11111111011001,11111111101100
		}
		
		/* Error: if n == 11..1100..00, then there is no bigger number with the same
		 * number of 1s.
		 * c0 + c1 = 2 + 5 = 7
		 */
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		// p = 7
		int p = c0 + c1; // position of rightmost non-trailing zero
		
		/*
		 * (1 << p) = 10000000
		 * n |= (1 << p) = 13,948 |= 10000000 = 1101100-1111100 |= 000000-10000000 = 11011001111100
		 */
		n |= (1 << p); // Flip rightmost non-trailing zero
		/*
		 * (1 << p) = 10000000
		 * (1 << p) -1 = 10000000 - 00000001 = 01111111
		 * ~((1 << p) -1) = 1000000
		 * n &= ~((1 << p) -1) = 1101100-1111100 &= 111111-1000000 = 11011001000000
		 */
		n &= ~((1 << p) -1); // Clear all bits to the right of p
		/*
		 * 1 << (c1 - 1) = 1 << ( 5 - 1) = 1 << 4 = 10000
		 * (1 << (c1 - 1)) -1 = 10000 - 1 = 01111
		 * n |= (1 << (c1 - 1)) - 1 = 11011001000000 |= 00000000001111 = 11011001001111
		 * 															   11011010001111
		 */
		n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on the right.
		return n;
	}
	
	// Bit Manipulation Approach for Get Previous Number
	int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (temp & 1 == 1) {
			c1++;
			temp >>= 1;
		}
		if (temp == 0) return -1;
		
		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		
		int p = c0 + c1; // position of rightmost non-trailing one
		n &= ((~0) << (p + 1)); // clears from bit p onwards
		
		int mask = (1 << (c1 + 1)) -1; // Sequence of (c1+1) ones
		n |= mask << (c0 - 1);
		
		return n;
	}
	
	
}

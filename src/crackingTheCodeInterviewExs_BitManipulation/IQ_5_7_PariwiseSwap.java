package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_7_PariwiseSwap {
	// Index 12345678    12345678
	// 	     01010101 => 00101010
	
	int swapOddEvenBits(int x) {
		// 0xaa = 10101010
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
	}
}

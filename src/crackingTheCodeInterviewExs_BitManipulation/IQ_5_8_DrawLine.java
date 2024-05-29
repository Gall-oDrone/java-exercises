package crackingTheCodeInterviewExs_BitManipulation;

public class IQ_5_8_DrawLine {
	
	/*
	*   		   1            8,16,32,...,d*8
	* array = [0,1,0,1,0,...1]
	* screen= [0,1,0,1,0,...1]
	* width w = 8, 16, 24, 32, 40, 48, 56, 72 80, ... d*8 
	* height h depends on length of array and width
	*/
	
	void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8; // 0,1,2,3,4,5,6,7
		int first_full_byte = x1 / 8; // 0,1,2,3,4,5,6,7,8,9,10,...,+N
		if (start_offset != 0) { // not divisible by 8 e.g. start_offset = 1 => x1 = 9
			first_full_byte++; // first_full_byte = 1 + 1 = 2
		}
		// If x1 = 9, x2 = {17, 25, 33,...}
		// end_offset = 1
		// last_full_byte = 2,3,4,5,6,7,8,9,10,...
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) { // if x1 = 15, then x2 = {23,31,39,47,...}, end_offset = 7  
			last_full_byte--; // last_full_byte = {2,3,4,5,6,7,8,9,10,...} -1 => {1,2,3,4,5,6,7,8,9,...} 
		}
		
		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}
		
		// Create masks for start and end of line
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		// Set start and end of line
		if ((x1 / 8) == (x2 / 8)) { // x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask); // both 0 or 1
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}
}

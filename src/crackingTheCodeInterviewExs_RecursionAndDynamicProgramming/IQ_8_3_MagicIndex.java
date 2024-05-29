package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

public class IQ_8_3_MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* Brute force solution */
	int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	/* 
	 * 5 6 7 8 9 10 11
	 * 1 2 3 4 5 6  7
	 * */
	
	int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFast(array, start, mid -1);
		} else {
			return magicFast(array, start, mid + 1);
		}
	}
	
	int magicFastOptimal(int[] array, int start, int end) {
		if (end < start) return -1;
		
		int midIndex = (start+end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		
		/* Search left */
		int leftIndex = Math.min(midIndex -1, midValue);
		int left = magicFastOptimal(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastOptimal(array, rightIndex, end);
		
		return right;
	}
}

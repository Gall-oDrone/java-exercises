package leetCodeExcercises1;

public class MedianOfTwoSortedArrayOfDifferentLength {
	
	public double findMedianSortedArrays(int input1[], int input2[]) {
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		
		int x = input1.length; // siempre el menor
		int y = input2.length; // siempre el mayor
		
		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
			
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
			
		}
		
		throw new IllegalArgumentException();

	}
	public static void main(String[] args) {
		int[] x = {1,3,8,9,15};
		int[] y = {7,11,19,21,18,25};
		
		MedianOfTwoSortedArrayOfDifferentLength mm = new MedianOfTwoSortedArrayOfDifferentLength();
		mm.findMedianSortedArrays(x, y);
	}	
}


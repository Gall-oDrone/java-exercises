package crackingTheCodeInterviewExs_SortingAndSearching;

public class IQ_10_MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}
	
	void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle+1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}
	
	void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/* Iterate through helper array. Compare the left and right half, copying back 
		 * the smaller element from the two halves into the original array.
		 */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= middle && helperRight <= high) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/* Copy the rest of the left side of the array into the target array
		 */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}	
	}
}

package leetCodeExcercises1;

public class LC_TwoSum_2_167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int[] twoSums(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		
		while(left < right) {
			if(numbers[left] + numbers[right] > target) {
				right = right - 1;
			}
			else if (numbers[left] + numbers[right] < target) {
				left = left + 1;
			}
			else {
				return new int[] {left+1, right+1};
			}
		}
		return null;
	}
	
	

}

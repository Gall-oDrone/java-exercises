package leetCodeExcercises1;

import java.util.Arrays;

public class LC_ProductOfAnArrayExceptSelf_238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int[] productExceptSelf(int[] nums) {
		
		int[] result = new int[nums.length];
		
		Arrays.fill(result, 1);
		
		int pre = 1, post = 1;
		
		for(int i = 0; i< nums.length; i++) {
			result[i] = pre;
			pre = nums[i]*pre;
		}
		
		for(int i=nums.length-1; i>=0; i--) {
			result[i] = result[i]*post;
			post = post*nums[i];
		}
		
		return result;
	}

}

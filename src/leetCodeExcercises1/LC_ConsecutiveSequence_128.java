package leetCodeExcercises1;

import java.util.HashSet;

public class LC_ConsecutiveSequence_128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int longestConsecutive(int[] nums) {
		
		if(nums.length == 0) {
			return 0;
		}
		
		HashSet<Integer> numSet = new HashSet<>();
		for(int i=0; i < nums.length; i++) {
			numSet.add(nums[i]);
		}
		
		int longestSub = 1;
		
		for (int num:numSet) {
			if(numSet.contains(num-1)) {
				continue;
			}
			else {
				int currentNum = num;
				int currentSub = 1;
				while(numSet.contains(currentNum+1)) {
					currentNum++;
					currentSub++;
				}
				
				longestSub = Math.max(currentSub, longestSub);
			}
		}
		return longestSub;
	}

}

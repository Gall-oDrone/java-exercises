package leetCodeExcercises1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC_TopKFrequentElements_357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int[] topKFrequent(int[] nums, int k){
		
		if (k == nums.length) {
			return nums;
		}
		
		Map<Integer, Integer> count = new HashMap<>();
		for(int n:nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}
		
		Queue<Integer> heap = new PriorityQueue<>(
				(a,b) -> count.get(a)-count.get(b));
		
		for(int n:count.keySet()) {
			heap.add(n);
			if(heap.size() > k) {
				heap.poll();
			}
		}
		
		int[] ans = new int[k];
		for (int i = 0; i <k; i++) {
			ans[i] = heap.poll();
		}
		
		return ans;
	}

}

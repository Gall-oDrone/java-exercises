package TutorialRecursion;

import java.util.HashMap;
import java.util.Map;

public class memoAndCatching {

	Map<Integer, Integer> memoizedCache = new HashMap<>();
	memoizedCache.put(1,1);
	memoizedCache.put(0,1);
	
	public static long fib(long n) {
		if (memoizedCache.containsKey(n)) {
			return memoizedCache.get(n);
		}
		int result = fib(n-1) + fib(n-2);
		memoizedCache.put(n, result);
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}

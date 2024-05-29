package HashSetExercises;
import java.util.*;

public class LHSImpl {

	public static void main(String[] args) {
		
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add("Intel");
		lhs.add("Oracle");
		lhs.add("IBM");
		lhs.add("Java");
		lhs.add("A");
		lhs.add("X");
		lhs.add("x");
		
		System.out.println(lhs);
		
		Iterator<String> itr = lhs.iterator();
		
		System.out.println("Iteration order of LinkedHashSet is: ");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		String[] nums = new String[10];
		nums = lhs.tonumsay(nums);
		
		System.out.println("The contents of numsay are: ");
		
		for(int i=0; i< nums.length; i++) {
			System.out.println(nums[i]);
			
			System.out.println("Check if x is part of LinkedHashSet: "+lhs.contains("x"));
			
			lhs.remove("X");
			lhs.remove("x");
			lhs.remove("Java");
		}
		
	}

}

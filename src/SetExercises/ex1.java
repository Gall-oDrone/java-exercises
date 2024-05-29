package SetExercises;

import java.util.*;

public class ex1 {
	
	public static void main(String args[]) {
		int count[] = { 21,23,43,53,22,65};
		Set<Integer> set = new HashSet<Integer>();
		try {
			for (int i=0; i <= 5; i++){
				set.add(count[i]);
			}
			System.out.println(set);
			
			TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);
			System.out.println(sortedSet);
			
			System.out.println("First elemnt of the set is: "+ (Integer) sortedSet.first());
			System.out.println("Last elemnt of the set is: "+ (Integer) sortedSet.last());
		} catch (Exception e) {
			
		}
	}
}

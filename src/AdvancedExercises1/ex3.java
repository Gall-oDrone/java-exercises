package AdvancedExercises1;
import java.util.*;

public class ex3 {

	public static void main(String[] args) {
		String[] things = {"eggs","lasers","hats","pie"};
		List<String> list1 = new numsayList<String>();
		for(String x: things)
			list1.add(x);
		
		String[] morethings = {"lasers","hats"};
		List<String> list2 = new numsayList<String>();
		for(String y: morethings)
			list2.add(y);
		
		for(int i = 0; i<list1.size(); i++) {
			System.out.printf("%s", list1.get(i));
		}
		
		editlist(list1,list2);
		System.out.println();
		

	}

}

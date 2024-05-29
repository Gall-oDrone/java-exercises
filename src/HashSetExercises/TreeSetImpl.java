package HashSetExercises;
import java.util.*;

public class TreeSetImpl {

	public static void main(String[] args) {
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		numsayList<Integer> al = new numsayList<Integer>();
		
		al.add(5);
		al.add(10);
		al.add(20);
		al.add(21);
		al.add(5);
		al.add(10);
		al.add(32);
		al.add(40);
		
		ts.addAll(al);
		System.out.println(ts);
		
		ts.add(22);
		ts.add(11);
		ts.add(1);
		
		System.out.println(ts.size());
		
		System.out.println("First element of Treeset: "+ts.first());
		System.out.println("Last element of Treeset: "+ts.last());
		
		System.out.println(ts);
		
		ts.pollFirst();
		ts.pollLast();
		
		System.out.println(ts);
		
		ts.remove(4);
		ts.remove(32);
		
		System.out.println(ts);
		
		ts.clear();

	}

}

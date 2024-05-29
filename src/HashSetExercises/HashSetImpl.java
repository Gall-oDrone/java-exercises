package HashSetExercises;
import java.util.*;


public class HashSetImpl {

	public static void main(String[] args) {
		
		numsayList<Integer> a1 = new numsayList<Integer>();
		numsayList<Integer> a2 = new numsayList<Integer>();
		
		HashSet<numsayList> hs = new HashSet<numsayList>();
		
		a1.add(12);
		a1.add(21);
		a1.add(87);
		a1.add(12);
		a1.add(2);
		a1.add(87);
		
		System.out.println(a1);
		System.out.println(a2);
		
		hs.add(a1);
		hs.add(a2);
		
		System.out.println(hs.size());
		System.out.println(hs);
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		
		hs1.add(5);
		hs1.add(22);
		hs1.add(32);
		hs1.add(5);
		hs1.add(32);
		hs1.add(11);
		hs1.add(21);
		
		System.out.println(hs1);
		
		System.out.println("The hashcode of hashset hs1:"+hs1.hashCode());
		System.out.println("The hashcode of hashset hs:"+hs.hashCode());

		Iterator<Integer> itr = hs1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		hs1.remove(32);
		hs1.remove(11);
		hs.remove(a1);
		
		System.out.println(hs);
		System.out.println(hs1);
		
	}

}

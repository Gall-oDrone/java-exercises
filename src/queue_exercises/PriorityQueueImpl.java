package queue_exercises;
import java.util.*;

public class PriorityQueueImpl {
	public static void main(String args[]) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(4);
		System.out.println(pq);
		pq.add(2);
		System.out.println(pq);
		pq.add(1);
		System.out.println(pq);
		pq.add(3);
		System.out.println(pq);
		
		System.out.println("The element present at the front end is: "+pq.peek());
		
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		pq.poll();
		pq.remove();
		pq.poll();
		System.out.println("The priority queue after removal: "+pq);
	}
}

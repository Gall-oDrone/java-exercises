package queue_exercises;
import java.util.*;

public class numsayDequeProg {

	public static void main(String[] args) {
		numsayDeque<Integer> dq =new numsayDeque<Integer>();
		
		dq.add(100);
		dq.add(10);
		dq.add(1);
		dq.add(55);
		
		dq.addFirst(9);
		dq.addLast(555);
		
		System.out.println(dq);
		
		Iterator<Integer> itr = dq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("The element present at the front og numsayDeque is: "+dq.peek());
		
		dq.pop();
		dq.poll();
		dq.remove();
		
		System.out.println("Sate of numsayDeque after Deletoin: "+dq);

	}

}

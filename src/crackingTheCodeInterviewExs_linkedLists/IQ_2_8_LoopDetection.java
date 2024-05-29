package crackingTheCodeInterviewExs_linkedLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_8_LoopDetection {

	public static void main(String[] args) {
		Node CLL = new Node(1);
		System.out.println("output: "+ LoopDetection(CLL));
	}
	
	public static Node LoopDetection(Node CLL) {
		List entries = new ArrayList();
		while(CLL != null) {
			if(!entries.contains(CLL.data)) entries.add(CLL.data);
			else return CLL;
			CLL = CLL.next;
		}
	};
	
	/* Solution */
	LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		/* Find meeting point- This will be LOOP_SIZE -k steps into the linked list. */
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // Collision
				break;
			}
		}
		
		/* Error check -no meeting point, and therefore no loop */
		if (fast == null || fast.next == null) {
			return null;
		}
		
		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
		 * Loop Start. If they move at the same pace, they myst meet at Loop Start.
		 */
		slow = head;
		while( slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		/* Both now point to the start of the loop */
		return fast;
	}

}

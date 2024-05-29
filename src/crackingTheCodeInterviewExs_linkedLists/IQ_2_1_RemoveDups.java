import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_1_RemoveDups {

	public static void main(String[] args) {
		Node h;
		Node on = removeDupNode(h);
	}
	
	Node removeDupNode(Node head) {
		Node n = head;
		ArrayList<Integer> valArr = new ArrayList<Integer>();
		valArr.add(head.data);
		int d = 0;
		while(n.next != null) {
			if(valArr.contains(n.next.data)) {
				n.next = n.next.next;
				// deleteNode(n, d);
			}
			valArr.add(head.next.data);
			n = n.next;
			d ++;
		}
		return head;
	}
	
	//Solution
		void deleteDups(LinkedListNode n) {
			HashSet<Integer> set = new HashSet<Integer>();
			LinkedListNode previous = null;
			while (n != null) {
				if (set.contains(n.data)) {
					previous.next = n.next;
				} else {
					set.add(n.data);
					previous = n;
				}
				n = n.next;
			}
		}
		
		// Follow up: No buffer allowed
		void deleteDups(LinkedListNode head) {
			LinkedListNode current = head;
			while (current != null) {
				LinkedListNode runner = current;
				while (runner.next != null) {
					if (runner.next.data == current.data) {
						runner.next = runner.next.next;
					} else {
						runner = runner.next;
					}
				}
				current = current.next;
			}
		}
}

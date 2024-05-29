package crackingTheCodeInterviewExs_linkedLists;

import java.util.ArrayList;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_2_ReturnKthToLast {

	public static void main(String[] args) {
		System.out.println("output: "+ ReturnKthToLast());
	}
	
	public static void ReturnKthToLast(Node head, int k) {
		Node n = null;
		int counter = k;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while (head.next != null) {
			if(counter == 0) {
				al.add(head.data);
				n.next.data = head.next.data;
			}
			head = head.next;
			counter --;
		}
	}

}


// Solution #1: if linked list size is known
// (length - k)th element
// Solution #2: Recursive
// Approach A
int printKthToLast(LinkedListNode head, int k) {
	if(head == null) {
		return 0;
	}
	int index = printKthToLast(head.next,k) + 1;
	if (index == k) {
		System.out.println(k + "th to last node is " + head.data);
	}
	return index;
}
//Solution #3: Iterative
LinkedListNode nthToLast(LinkedListNode head, int k) {
	LinkedListNode p1 = head;
	LinkedListNode p2 = head;
	
	for (int i=0; i<k; i++) {
		if (p1 == null) return null;
		p1 = p1.next;
	}
	
	while (p1 != null) {
		p1 = p1.next;
		p2 = p2.next;
	}
	return p2;
}
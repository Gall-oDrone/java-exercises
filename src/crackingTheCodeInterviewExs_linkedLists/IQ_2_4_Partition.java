package crackingTheCodeInterviewExs_linkedLists;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_4_Partition {

	public static void main(String[] args) {
		int x = 5;
		Node ll = null;
		System.out.println("Output: "+ Partition(ll, x));

	}
	
	public static void Partition(Node LinkedList, int x) {
		int val = 0;
		int partition = x - 1;
		Node copy = LinkedList;
		Node left = null;
		Node right = null;
		while(copy  != null) {
			if(partition == 0) {
				val = copy .data;
			}
			partition--;
			copy = copy.next;
		}
		while(copy  != null) {
			if(copy.data < val) {
				left.data = val;
				left = left.next;
			} else {
				right.data = val;
				right = right.next;
			}
			copy = copy.next;
		}
	}
}

// Solution
LinkListNode partition(LinkedListNode node, int x) {
	LinkListNode beforeStart = null;
	LinkListNode beforeEnd = null;
	LinkListNode afterStart = null;
	LinkListNode afterEnd = null;
	
	/* Partition list */
	while (node != null) {
		LinkedListNode next = node.next;
		node.next = null;
		if (node.data < x) {
			/* Insert node into end of before list */
			if (beforeStart == null) {
				beforeStart = node;
				beforeEnd = beforeStart;
			} else {
				beforeEnd.next = node;
				beforeEnd = node;
			}
		} else {
			/* Insert node into end of after list */
			if (afterStart == null) {
				afterStart = node;
				afterEnd = afterStart;
			} else {
				afterEnd.next = node;
				afterEnd = node;
			}
		}
		node = next;
	}
	if(beforeStart == null) {
		return afterStart;
	}
	
	beforeEnd.next = afterStart;
	return beforeStart;
}

// Approach 2
LinkedListNode partition(LinkedListNode node, int x) {
	LinkedListNode head = node;
	LinkedListNode tail = node;
	
	while (node != null) {
		LinkedListNode next = node.next;
		if (node.data < x) {
			node.next = head;
			head= node;
		} else {
			tail.next = node;
			tail = node;
		}
		node = next;
	}
	tail.next = null;
	return head;
}


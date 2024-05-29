package crackingTheCodeInterviewExs_linkedLists;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_5_SumLists {

	public static void main(String[] args) {
		String num1 = "";
		String num2 = "";
		int cum = 0;
		Node LL1, LL2 = null;
		Node out = SumLists(LL1,LL2, cum);
		System.out.println("output: "+ out);
	}
	
	public static int Recursive(Node LL) {
		// Returns Linked list in original order and sums up
		return Integer.parseInt(Recursive(LL.next) + String.valueOf(LL.data));
	}
	
	public static Node SumLists(Node LL1,Node LL2,String n1, String n2, int cum) {
		cum = Recursive(LL1)+Recursive(LL2); // expected output 912 as int
		String scum = String.valueOf(cum);
		Node out = null;
		for (int i = scum.length(); i >= 0; i--) {
			char c = scum.charAt(i);
			out.data = Integer.parseInt(String.valueOf(c));
			out = out.next;
		return out;
					
		}
		
	}

}

// Solution
LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
	if(l1 == null && l2 == null && carry == 0) {
		return null;
	}
	
	LinkedListNode result = new LinkedListNode();
	int value = carry;
	if (l1 != null) {
		value += l1.data;
	}
	if (l2 != null) {
		value += l2.data;
	}
	
	result.data = value % 10;
	
	/* Recurse */
	if (l1 != null || l2 != null) {
		LinkedListNode more = addLists(l1 == null ? null : l1.next, 
										l2 == null ? null : l2.next,
										value >= 10 ? 1: 0);
		result.setNext(more);
	}
	return result;
}

/* Follow up*/
class PartialSum {
	public LinkedListNode sum = null;
	public int carry = 0;
}

LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
	int len1 = length(l1);
	int len2 = length(l2);
	
	/* Pad the shorter list with zeros */
	if (len1 < len2) {
		l1 = padList(l1,len2 - len1);
	} else {
		l2 = padList(l2, len1 - len2);
	}
	
	/* Add lists */
	PartialSum sum = addListsHelper(l1, l2);
	
	/* If there was a carry value left over, insert this at the front of the list.
	 * Otherwise, just return the linked list. */
	if (sum.carry == 0) {
		return sum.sum;
	} else {
		LinkedListNode result = insertBefore(sum.sum, sum.carry);
		return result;
	}
}

PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
	if (l1 == null && l2 == null) {
		PartialSum sum = new PartialSum();
		return sum;
	}
	/* Add smaller digits recursively */
	PartialSum sum = addListsHelper(l1.next, l2.next);
	
	/* Add carry to current data */
	int val = sum.carry + l1.data + l2.data;
	
	/* Insert sum of current digits */
	LinkedListNode full_result = insertBefore(sum.sum, val % 10);
	
	/* Return sum so far, and the carry value */
	sum.sum = full_result;
	sum.carry = val / 10;
	return sum;
}

/* Pad the list with zeros */
LinkedListNode padList(LinkedListNode l, int padding) {
	LinkedListNode head = 1;
	for (int i = 0; i< padding; i++) {
		head = insertBefore(head, 0);
	}
	return head;
}

/* Helper functino to isnert node in the front of a linked list */
LinkedListNode insertBefore(LinkedListNode list, int data) {
	if (list != null) {
		node.next = list;
	}
	return node;
}

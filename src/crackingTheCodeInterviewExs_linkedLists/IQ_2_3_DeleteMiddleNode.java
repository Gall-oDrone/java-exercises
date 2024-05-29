package crackingTheCodeInterviewExs_linkedLists;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_3_DeleteMiddleNode {

	public static void main(String[] args) {
		Node node = new Node(1);
		System.out.println("Outcome: "+ DeleteMiddleNode(node));
	}
	
	public static void DeleteMiddleNode(Node n) {
		Node copy = n;
		int even = 0;
		int middle = 0;
		while(copy != null) {
			even ++;
			copy = copy.next;
		}
		if(even > 2) {
			if(even % 2 == 0) {
				middle = (even/2)-1;
				while(n != null) {
					if(middle==0) {
						n.next = copy.next.next;	
					} else {
						n.next = copy.next;
					};
					copy = copy.next;
					middle--;
				}
			} else {
				middle = even/2;
				while(n != null) {
					if(middle==0) {
						n.next = copy.next.next;	
					} else {
						n.next = copy.next;
					};
					copy = copy.next;
					middle--;
				}
			}
		}
	}

}

// Solution
boolean deleteNode(LinkedListNode n) {
	if (n == null || n.next == null) {
		return false;
	}
	 LinkedListNode next = n.next;
	 n.data = next.data;
	 n.next = next.next;
	 return true;
}

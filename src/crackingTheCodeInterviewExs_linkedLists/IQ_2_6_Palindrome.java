package crackingTheCodeInterviewExs_linkedLists;

import java.util.Stack;

import crackingTheCodeInterviewExs_linkedLists.Ex1.Node;

public class IQ_2_6_Palindrome {

	public static void main(String[] args) {
		Node ll = new Node(1);
		System.out.println("output: "+ Palindrome(ll));
	}
	
	public static Boolean Recursive(Node LL, String cum, String cum2) {
		if (LL == null) {
			if(cum == cum2) return true;
			return false;
		}
		cum = cum + LL.data;
		cum2 = LL.data + cum2;
		return Recursive(LL.next, cum, cum2);
	}
	
	public static Boolean Palindrome(Node LL) {
		String cum = "", cum2 = "";
		return Recursive(LL, cum, cum2);
	}
	
	// Solution #1: Reverse and Compare
	boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reversedClone(head);
		return isEqual(head, reversed);
	}
	
	LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	
	boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
	// Solution #2: Iterative Approach
	boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			
			/**/
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	// Solution #3: Recursive Approac
	/* Intuition
	recurse(Node n, int length) {
		if (length == 0 || length == 1) {
			return [something];
		}
		recurse(n.next, length - 2);
	}
	*/
	boolean isPalindrome(LinkedListNode head, int length) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}
	
	Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { //Odd number of nodes
			return new Result(head.next, true);
		}
		
		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res;
		}
		
		res.result = (head.data == res.node.data);
		
		res.node = res.node.next;
		
		return res;
	}
	
	int lengthOfList(LinkedListNode n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
}

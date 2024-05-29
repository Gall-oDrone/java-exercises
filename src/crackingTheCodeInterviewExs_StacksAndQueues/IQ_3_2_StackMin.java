package crackingTheCodeInterviewExs_StacksAndQueues;
import java.util.EmptyStackException;
import java.util.Stack;

import crackingTheCodeInterviewExs_StacksAndQueues.StackImplementation.MyStack.StackNode;

public class IQ_3_2_StackMin {

	
	public class MyStack<T> {
		private static class StackNode<T> {
			private T data;
			private StackNode<T> next;
			
			public StackNode(T data) {
				this.data = data;
			}
		}
		
		private StackNode<T> top;
		
		public T pop() {
			if (top == null) throw new EmptyStackException();
			T item = top.data;
			top  = top.next;
			return item;
		}
		
		public int min() {
			if (top == null) throw new EmptyStackException();
			int min = (int) top.data;
			while(top != null) {
				int next = (int) top.next.data;
				if(min > next) min = next;
				top = top.next;
			}
			return min;
		}
		
		public void push(T item) {
			StackNode<T> t = new StackNode<T>(item);
			t.next = top;
			top = t;
		}
		
		public T peek() {
			if (top == null) throw new EmptyStackException();
			return top.data;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
	}
	
	/* Solution */
	public class StackWithMin extends Stack<NodeWithMin> {
		public void push(int value) {
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}
		
		public int min() {
			if (this.isEmpty()) {
				return Integer.MAX_VALUE; // Error value
			} else {
				return peek().min;
			}
		}
	}
	
	class NodeWithMin {
		public int value;
		public int min;
		public NodeWithMin(int v, int min) {
			value = v;
			this.min = min;
		}
	}
	
	/* Solution 2 */
	public class StackWithMin2 extends Stack<Integer> {
		Stack<Integer> s2;
		public StackWithMin2() {
			s2 = new Stack<Integer>();
		}
		
		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}
		
		public Integer pop() {
			int value = super.pop();
			if (value == min()) {
				s2.pop();
			}
			return value;
		}
		
		public int min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}
}

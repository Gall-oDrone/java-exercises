package crackingTheCodeInterviewExs_StacksAndQueues;

import java.util.Stack;

public class IQ_3_5_SortStack {
	
	public class SortStack<T>{
		Stack<Integer> stack1, stack2;
		
		public SortStack() {
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}
		
		public void add(T value){
			stack1.push(value);
		}
		
		private void sortStack() {
			int minVal = 0;
			while (stack1 != null) {
				minVal = stack1.data;
				if (stack1.next != null) {
					if (stack1.next.data < minVal) minVal = stack1.next.data;
				}
				stack1 = stack1.next;
			}
			while (!stack1.isEmpty()) {
				int val = stack1.peek();
				while(stack1.next != null) {
					if (stack1.data > val) val = stack1.data;
					stack1 = stack1.next;
				}
			}
		}
		
		/* Solution */
		private void sort(Stack<Integer> s) {
			Stack<Integer> r = new Stack<Integer>();
			while(!s.isEmpty()) {
				/* Insert each element in s in sorted order into r. */
				int tmp = s.pop();
				while(!r.isEmpty() && r.peek() > tmp) {
					s.push(r.pop());
				}
				r.push(tmp);
			}
			
			/* Copy the elements from r back into s. */
			while(!r.isEmpty()) {
				s.push(r.pop());
			}
		}
	}
	
}

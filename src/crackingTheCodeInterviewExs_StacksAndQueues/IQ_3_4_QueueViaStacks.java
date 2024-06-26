package crackingTheCodeInterviewExs_StacksAndQueues;

import java.util.Stack;

public class IQ_3_4_QueueViaStacks {
	public class MyQueue<T> {
		Stack<T> stackNewest, stackOldest;
		
		public MyQueue() {
			stackNewest = new Stack<T>();
			stackOldest = new Stack<T>();
		}
		
		public int size() {
			return stackNewest.size() + stackOldest.size();
		}
		
		public void add(T value) {
			/* Push onto stackNewest, which always has the newest elements on top */
			stackNewest.push(value);
		}
		
		/* Move elements from stackNewest int ostackOldest. This is usually done so that
		 * we can do operations on stackOldest
		 */
		private void shiftStacks() {
			if (stackOldest.isEmpty()) {
				while (!stackNewest.isEmpty()) {
					stackOldest.push(stackNewest.pop());
				}
			}
		}
		
		public T peek() {
			shiftStacks(); // Ensure stackOldest has the current elements
			return stackOldest.peek(); // retrieve the oldest item.
		}
		
		public T remove() {
			shiftStacks(); // Ensure stackOldest has the current elements
			return stackOldest.pop(); // pop the oldest item.
		}
	}
}

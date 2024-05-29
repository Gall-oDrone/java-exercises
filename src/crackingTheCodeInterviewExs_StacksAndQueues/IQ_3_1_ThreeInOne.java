package crackingTheCodeInterviewExs_StacksAndQueues;

import java.util.EmptyStackException;

public class IQ_3_1_ThreeInOne {

	public static void main(String[] args) {
		
	}
	
	/* Solution */
	class FixedMultiStack {
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;
		
		public FixedMultiStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numberOfStacks];
			sizes = new int[numberOfStacks];
		}
		
		/* Push value onto stack. */
		public void push(int stackNum, int value) throws FullStackException {
			/* Check that we have space for the next element */
			if (isFull(stackNum)) {
				throw new FullStackException();
			}
			
			/* Increment stack pinter and then update top value. */
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}
		
		/* Pop item from top stack. */
		public int pop(int stackNum) {
			if (isEmpty(stackNum) ) {
				throw new EmptyStackException();
			}
			
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex]; // Get top
			values[topIndex] = 0;
			sizes[stackNum]--; // Shrink
			return value;
		}
		
		/* Return top element */
		public int peek(int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			return values[indexOfTop(stackNum)];
		}
		
		/* Return if stack is empty. */
		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}
		
		/* Return if stack if full. */
		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}
		
		/* Returns index of the top of the stack. */
		private int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size -1;
		}
	}
	
	/* Approach 2: Flexible Divisions */
	public class MultiStack2 {
		
		private class StackInfo {
			public int start, size, capacity;
			public StackInfo(int start, int capacity) {
				this.start = start;
				this.capacity = capacity;
			}
			
			public boolean isWithinStackCapacity(int index) {
				/* if outside of bound of array, return false. */
				if (index < 0 || index >= values.length) return false;
				
				/* If index wraps around, adjust it. */
				int contiguousIndex = index < start ? index + values.length : index;
				int end = start + capacity;
				return start <= contiguousIndex && contiguousIndex < end;
			}
			
			public int lastCapacityIndex() {
				return adjustIndex(start + capacity - 1);
			}
			
			public int lastElementIndex() {
				return adjustIndex(start + size - 1);
			}
			
			public boolean isFull() { return size == capacity; }
			public boolean isEmpty() { return size == 0; }
		}
		
		private StackInfo[] info;
		private int[] values;
		
		public MultiStack(int numberOfStacks, int defaultSize) {
			/* Create meta-data for all the stacks. */
			info = new StackInfo[numberOfStacks];
			for (int i = 0; i < numberOfStacks; i++) {
				info[i] = new StackInfo(defaultSize * i, defaultSize);
			}
			values = new int[numberOfStacks * defaultSize];
		}
		
		public void push(int stackNum, int value) throws FullStackException {
			if (allStacksAreFull()) {
				throw new FullStackException();
			}
			
			/* If this stack is full, expand it. */
			StackInfo stack = info[stackNum];
			if (stack.isFull()) {expand(stackNum);}
			
			/* Find the index of the top element in the array + 1, and increment the
			 * stack pointer
			 */
			stack.size++;
			values[stack.lastElementIndex()] = value;
		}
		
		/* Remove value from stack. */
		public int pop(int stackNum) throws Exception {
			StackInfo stack = info[stackNum];
			if (stack.isEmpty()) {
				throw new EmptyStackException();
			}
			
			/* Remove last element */
			int value = values[stack.lastElementIndex()];
			values[stack.lastElementIndex()] = 0; // Clear item
			stack.size--; // Shrink size
			return value;
		}
		
		/* Get top element of stack. */
		public int peek(int stackNum) {
			StackInfo stack = info[stackNum];
			return values[stack.lastElementIndex()];
		}
		
		/*Shift items in stack over by one element. */
		private void shift(int stackNum) {
			System.out.println("/// Shifting " + stackNum);
			StackInfo stack = info[stackNum];
			
			if (stack.size >= stack.capacity) {
				int nextStack = (stackNum + 1) % info.length;
				shift(nextStack);
				stack.capacity++; // claim index that next stack lost
			}
			
			/* Shift all elements in stack over by one. */
			int index = stack.lastCapacityIndex();
			while (stack.isWithinStackCapacity(index)) {
				values[index] = values[previousIndex(index)];
				index = previousIndex(index);
			}
			
			/* Adjust stack data. */
			values[stack.start] = 0; // Clear item
			stack.start = nextIndex(stack.start); // move start
			stack.capacity--; // Shrink capacity
			
		}
		
		/* Expand stack by shifting over other stacks */
		private void expand(int stackNum) {
			shift((stackNum + 1) % info.length);
			info[stackNum].capacity++;
		}
		
		/* Returns the number of items actually present in stack. */
		public int numberOfElements() {
			int size = 0;
			for (StackInfo sd: info) {
				size += sd.size;
			}
			return size;
		}
		
		/* Returns true is all the stacks are full */
		public boolean allStacksAreFull() {
			return numberOfElements() == values.length;
		}
		
		/* Adjust index to be within the range of 0 0 -> length -1. */
		private int adjustIndex(int index) {
			int max = values.length;
			return ((index % max) + max) % max;
		}
		
		/* Get index after this index, adjusted for wrap around. */
		private int nextIndex(int index) {
			return adjustIndex(index + 1);
		}
		
		/* Get index before this index, adjusted for wrap around. */
		private int previousIndex(int index) {
			return adjustIndex(index -1);
		}
	}

}

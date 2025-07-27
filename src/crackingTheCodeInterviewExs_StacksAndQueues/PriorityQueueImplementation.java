package crackingTheCodeInterviewExs_StacksAndQueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueueImplementation<T> {
	
	/* Usage Example */
	public static void main(String[] args) {
        // Min-heap using natural order
		PriorityQueueImplementation<Integer> pq = new PriorityQueueImplementation<>();

        pq.add(5);
        pq.add(3);
        pq.add(7);
        pq.add(1);

        System.out.println(pq);          // Output: [1, 3, 7, 5] (heap order)
        System.out.println(pq.poll());   // Output: 1
        System.out.println(pq.peek());   // Output: 3
        System.out.println(pq);          // Output: [3, 5, 7]
    }
	
	private Object[] heap; 		// Internal array for heap
	private int size; 			// Number of elements
	private Comparator<T> comparator;
	
	private static final int DEFAULT_CAPACITY = 16;
	
	/* Constructor using natural ordering (T Must implement Comparable) */
	public PriorityQueueImplementation() {
		this(null);
	}
	
	/* Constructor with custom comparator */
	public PriorityQueueImplementation(Comparator<T> comparator) {
		this.heap = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}
	
	/* Adds an element to the prioroty queue */
	public void add(T element) {
		if (element == null) throw new NullPointerException("Element cannot be null");
		
		ensureCapacity(size + 1);
		heap[size] = element;
		heapifyUp(size);
		size++;
	}
	
	/* Return and removes the highest-priority element */
	@SuppressWarnings("unchecked")
	public T poll() {
		if (size == 0) throw new NoSuchElementException("PriorityQueue is empty");
		
		T result = (T) heap[0];
		heap[0] = heap[--size];
		heap[size] = null;
		heapifyDown(0);
		
		return result;
	}
	
	/* Returns (but does not remove) the highest-priority element */
	@SuppressWarnings("unchecked")
	public T peek() {
		if (size == 0) throw new NoSuchElementException("PriorityQueue is empty");
		return (T) heap[0];
	}
	
	/* Returns the number of elements */
	public int size() {
		return size;
	}
	
	/* Returns true if the queue is empty */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/* Ensures enough internal array capacity */
	private void ensureCapacity(int minCapacity) {
		if (minCapacity > heap.length) {
			int newCapacity = heap.length * 2;
			heap = Arrays.copyOf(heap, newCapacity);
		}
	}
	
	/* Maintains heap property after insert (heapify up) */
	@SuppressWarnings("unchecked")
	private void heapifyUp(int index) {
		T current = (T) heap[index];
		while (index > 0) {
			int parentIdx = (index - 1) / 2;
			T parent = (T) heap[parentIdx];
			
			if (compare(current, parent) >= 0) break;
			
			heap[index] = parent;
			index = parentIdx;
		}
		heap[index] = current;
	}
	
	/* Maintains heap property after removal (heapify down) */
	@SuppressWarnings("unchecked")
	private void heapifyDown(int index) {
		T current = (T) heap[index];
		int half = size / 2; // Only non-leaf nodes need to be heapified
		
		while (index < half) {
			int left = index * 2 + 1;
			int right = left + 1;
			int smallest = left;
			
			if (right < size && compare((T) heap[right], (T) heap[left]) < 0) {
				smallest = right;
			}
			
			if (compare(current, (T) heap[smallest]) <= 0) break;
			
			heap[index] = heap[smallest];
			index = smallest;
		}
		
		heap[index] = current;
	}
	
	/* Compares two elements using comparator or natural ordering */
	@SuppressWarnings("unchecked")
	private int compare(T a, T b) {
		if (comparator != null) return comparator.compare(a, b);
		return ((Comparable<T>) a).compareTo(b);
	}
	
	/* Returns a string representation */
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder("[");
        
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i < size - 1) sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}

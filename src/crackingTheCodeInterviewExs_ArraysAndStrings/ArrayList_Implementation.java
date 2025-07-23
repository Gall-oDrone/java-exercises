package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.util.Arrays;

public class ArrayList_Implementation<T> {
	
	public static void main(String[] args) {
		// Usage Example
		ArrayList_Implementation<String> list = new ArrayList_Implementation<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");

        System.out.println(list); // Output: [apple, banana, cherry]

        list.remove(1);
        System.out.println(list); // Output: [apple, cherry]

        System.out.println("Item at index 1: " + list.get(1)); // Output: cherry
        System.out.println("Size: " + list.size()); // Output: 2
    }
	
	// Internal array to hold elements
	private Object[] elements;
	
	// Number of elements currently stored
	private int size;
	
	// Default initial capacity
	private static final int DEFAULT_CAPACITY = 10;
	
	/* Constructor with default capacity */
	public ArrayList_Implementation() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	/* Adds an element to the end of the list */
	public void add(T item) {
		ensureCapacity(size + 1); // Ensure there's room
		elements[size++] = item;
	}
	
	/* Retrieves the element at a given index */
	@SuppressWarnings("unckecked")
	public T get(int index) {
		checkIndex(index);
		return (T) elements[index];
	}
	
	/* Removes the element at the given index and shifts remaining element */
	@SupressWarnings("unchecked")
	public T remove(int index) {
		checkIndex(index);
		T removedElement = (T) elements[index];
		
		// Shift elements left to fill the gap
		for (int i = index; i < size -1; i++) {
			elements[i] = elements[i + 1];
		}
		
		elements[--size] = null; // Null out the last reference to help GC
		return removedElement;
	}
	
	/* Returns the current number of elements */
	public int size() {
		return size;
	}
	
	/* Ensure the internal array has enough space */
	private void ensureCapacity(int minCapacity) {
		if (minCapacity > elements.length) {
			int newCapacity = Math.max(elements.length*2, minCapacity);
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
	
	/* Checks that the index is within bounds */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	/* String representation of the list */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i < size - 1) sb.append(", ");
		}
		
		sb.append("]");
		return sb.toString();
	}
}

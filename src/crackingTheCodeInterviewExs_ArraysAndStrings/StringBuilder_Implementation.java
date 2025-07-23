package crackingTheCodeInterviewExs_ArraysAndStrings;

public class StringBuilder_Implementation {
	// Internal character array to store the string
	private char[] value;
	
	// Number of characters currently in the builder
	private int count;
	
	// Default initial capacity
	private static final int DEFAULT_CAPACITY = 16;
	
	/* Constructor with no initial string */
	public StringBuilder_Implementation() {
		value = new char[DEFAULT_CAPACITY];
		count = 0;
	}
	
	/* Constructor with initial string */
	public StringBuilder_Implementation(String str) {
		int initialCapacity = Math.max(DEFAULT_CAPACITY, str.length());
		value = new char[initialCapacity];
		append(str); // Use our own append logic
	}
	
	/* Append a string to the current builder */
	public StringBuilder_Implementation append(String str) {
		if (str == null) str = "null";
		
		int newLength = count + str.length();
		
		// Resize if needed
		ensureCapacity(newLength);
		
		// Copy characters from input string into internal array
		for (int i = 0; i < str.length(); i++) {
			value[count++] = str.charAt(i);
		}
		
		return this; // Return 'this' for chaining
	}
	
	/* Ensure the internal array has enough capacity */
	private void ensureCapacity(int minimumCapacity) {
		if (minimumCapacity > value.length) {
			int newCapacity = Math.max(value.length * 2, minimumCapacity);
			char[] newValue = new char[newCapacity];
			
			// Copy old data to new array
			for (int i = 0; i < count; i++) {
				newValue[i] = value[i];
			}
			
			value = newValue;
		}
	}
	
	/* Return the final string*/
	@Override
	public String toString() {
		// Create string from the first 'count' characters
		return new String(value, 0, count);
	}
}

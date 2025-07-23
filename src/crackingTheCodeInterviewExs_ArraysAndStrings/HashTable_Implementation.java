package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.util.Objects;

public class HashTable_Implementation<K,V> {

	public static void main(String[] args) {
		// Usage Example
		HashTable_Implementation<String, Integer> map = new HashTable_Implementation<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map.get("banana"));  // Output: 2
        map.remove("banana");
        System.out.println(map.get("banana"));  // Output: null
        System.out.println("Size: " + map.size());  // Output: 2
	}
	
	//Entry class represents a key-value pair
	private static class Entry<K,V> {
		K key;
		V value;
		Entry<K,V> next; // For chaining in case of collision
		
		public Entry(K key, V value, Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private Entry<K,V>[] table; // Array of buckets
	private int capacity; // Size of the table
	private int size; // Number of key-value pairs stored
	private static final float LOAD_FACTOR = 0.75f;
	
	private static final int DEFAULT_CAPACITY = 16;
	
	/* Default constructor */
	public HashTable_Implementation() {
		this.capacity = DEFAULT_CAPACITY;
		this.table = new Entry[capacity];
		this.size = 0;
	}

	/* Hash function to compute bucket index */
	private int hash(K key) {
		return Math.abs(Objects.hashCode(key)) % capacity;
	}
	
	/* Adds or updates a key-value pair */
	public void put(K key, V value) {
		int index = hash(key);
		
		Entry<K,V> head = table[index];
		
		// Check if key already exists and update
		while (head != null) {
			if (Objects.equals(head.key, key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		// Add new entry at the head of the chain
		Entry<K,V> newEntry = new Entry<>(key,value,table[index]);
		table[index] = newEntry;
		size++;
		
		// Resize if load factor exceeded
		if ((1.0 * size) / capacity >= LOAD_FACTOR) {
			resize();
		}
	}
	
	/* Retrieves value for a given key */
	public V get(K key) {
		int index = hash(key);
		Entry<K,V> head = table[index];
		
		while (head != null) {
			if (Objects.equals(head.key, key)) {
				return head.value;
			}
			head = head.next;
		}
		
		return null; // Key not found
	}
	
	/* Removes the key-value pair for the given key */
	public V remove(K key) {
		int index = hash(key);
		Entry<K,V> head = table[index];
		Entry<K,V> prev = null;
		
		while (head != null) {
			if (Objects.equals(head.key, key)) {
				if (prev == null) {
					table[index] = head.next;
				} else {
					prev.next = head.next;
				}
				size--;
				return head.value;
			}
			
			prev = head;
			head = head.next;
		}
		
		return null; // Key not found
	}
	
	/* Resize the hash table when load factor exceeds threshold */
	private void resize() {
		int newCapacity = capacity * 2;
		Entry<K,V>[] newTable = new Entry[newCapacity];
		
		// Rehash all existing entries
		for (Entry<K,V> head : table) {
			while (head != null) {
				int newIndex = Math.abs(Objects.hashCode(head.key)) % newCapacity;
				Entry<K,V> next = head.next;
				
				head.next = newTable[newIndex];
				newTable[newIndex] = head;
				
				head = next;
			}
		}
		table = newTable;
		capacity = newCapacity;
	}
	
	/* Returns number of key-value pairs */
	public int size() {
		return size;
	}
}

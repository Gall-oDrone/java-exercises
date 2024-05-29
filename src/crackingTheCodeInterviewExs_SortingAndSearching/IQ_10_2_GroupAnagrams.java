package crackingTheCodeInterviewExs_SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IQ_10_2_GroupAnagrams {

	public static void main(String[] args) {
		int[] array = new int[3];
		Arrays.sort(array, new AnagramComparator());
	}

	class AnagramComparator implements Comparator<String> {
		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
		
		void sort(String[] array) {
			HashMapList<String, String> mapList = new HashMapList<String, String>();
			
			/* Group words by anagram */
			for (String s: array) {
				String key = sortChars(s);
				mapList.put(key, s);
			}
			
			/* Convert hash table to array */
			int index = 0;
			for (String key : mapList.keySet()) {
				ArrayList<String> list = mapList.get(key);
				for (String t : list) {
					array[index] = t;
					index++;
				}
			}
		}
		
		String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		/* HashMapList<String, Integer> is a hashMap that maps from Strings to 
		 * ArrayList<Integer>. See appendix for implementation. */
		
	}
}

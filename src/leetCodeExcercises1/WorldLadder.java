package leetCodeExcercises1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorldLadder {
	
	public int ladderLength(String bwginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet();
		for (String word : wordList) {
			set.add(word);
		}
		if (!set.contains(endWord)) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList();
		queue.offer(beginWord);
		int level = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i< size; i++) {
				String current_word = queue.poll();
				char[] word_chars = current_word.toCharArray();
				for (int j=0; i<word_chars.length; j++) {
					char original_char = word_chars[j];
					for (char c = 'a'; c<'z'; c++) {
						if (word_chars[j] == c) continue;
						word_chars[j] = c;
						String new_word = String.valueOf(word_chars);
						if (new_word.equals(endWord)) return level + 1;
						if (set.contains(new_word)) {
							queue.offer(new_word);
							set.remove(new_word);
						}
					}
					
					word_chars[j] = original_char;
				}
			}
			
			
			level++;
		}
		
		return 0;
		
		
	}
}

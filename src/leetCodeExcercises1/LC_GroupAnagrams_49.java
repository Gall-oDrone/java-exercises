package leetCodeExcercises1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_GroupAnagrams_49 {

	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			
			if(strs.length == 0) return new ArrayList();
			
			Map<String, List> ansMap = new HashMap<>();
			
			int[] count = new int[26];
			
			for (String s:strs){
				Arrays.fill(count, 0);
				for(char c:s.toCharArray()) {
					count[c - 'a']++;
				}
				
				StringBuilder sb = new StringBuilder("");
				
				for(int i=0; i <26; i++) {
					sb.append("a");
					sb.append(count[i]);
				}
				String key = sb.toString();
				if(!ansMap.containsKey(key)) {
					ansMap.put(key, new ArrayList());
				}
				ansMap.get(key).add(s);
			}
			
			return new ArrayList(ansMap.values());
		}
	}
}

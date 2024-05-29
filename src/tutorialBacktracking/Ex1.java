package tutorialBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

public class Ex1 {

	public static void main(String[] args) {
		int n = 4;
		solve(n);
	}
	
	public static boolean is_valid_state(List<String> state, int n) {
		return state.size() == n;
	}
	
	public static int[] get_candidates(List<String> state, int n) {
		int candidates[] = {};
		if(state.isEmpty()) {
			for (int i = 0; i < n ; i++) { candidates[i] = i;}
			return candidates;
					
		}   
		
		// find the next position in the state to populate
		int position = state.size();
		candiadtes
		return candidates;
	}
	
	public static void search(List<String> state, List<Integer> solutions) {
		
		List<String> arrList = new ArrayList<String>(solutions.toArray());
		if(is_valid_state(state)) solutions.add(state.toArray());
		
		for(String[] candidate:get_candidates(state)) {
			state.add(candidate);
			search(state, solutions);
			state.remove(candidate);
		}
			
	}
	
	public static List<Integer> solve(int n) {
		List<Integer> solutions = new ArrayList<Integer>();
		List<String> state = new ArrayList<String>();
		search(state, solutions, n);
		return solutions;
	}

}

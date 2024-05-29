package TutorialRecursion;

import java.util.Set;

public class depthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean depthFirstSearh2(Node node, Set<Node> visited, int goal) {
		if (node == null) return false;
		
		if (node.val == goal) {
			return true;
		}
		
		for (Node neighbor : node.getNeighbors()) {
			if (visited.contains(neighbor)) continue;
			visited.add(neighbor);
			boolean isFound = depthFirstSearch(neighbor, visited, goal);
			
			if (isFound) return true;
		}
		return false;
	}

}

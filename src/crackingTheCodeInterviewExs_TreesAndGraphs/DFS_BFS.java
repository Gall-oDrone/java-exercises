package crackingTheCodeInterviewExs_TreesAndGraphs;

import java.util.Queue;

public class DFS_BFS {
	
	// DFS implementation
	void search(Node root) {
		if (root == null) return;
		vist(root);
		root.visited = true;
		foreach (Node n in root.adjacent) {
			if (n.visited == false) {
				search(n);
			}
		}
	}
	
	// BFS implementation
	void searchBFS(Node root) {
		Queue queue = new Queue();
		root.marked = true;
		queue.enqueue(root); // Add to the end of queue
		
		while (!queue.isEmpty()) {
			Node r = queue.dequeue(); // Remove from the front of the queue
			visit(r);
			foreach (Node n in r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.enqueue(n);
				}
			}
		}
	}
}

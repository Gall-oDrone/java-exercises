package crackingTheCodeInterviewExs_TreesAndGraphs;

import java.util.LinkedList;

import crackingTheCodeInterviewExs_TreesAndGraphs.GraphImplementation.Node;

public class IQ_4_1_RouteBetweenNodes {
	enum State { Univisited, Visited, Visiting; }
	
	boolean search(Graph g, Node start, Node end) {
		if (start == end) return true;
		
		// oNodetes as Queue
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (Node u : g.getNodes()) {
			u.state = State.Univisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // i.e., dequeue()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
}

package crackingTheCodeInterviewExs_SortingAndSearching;

public class IQ_10_10_GroupAnagrams {

	/*
	int getRank(Node node, int x) {
		if x is node.data, return node.leftSize();
		if x is on left of node, return getRank(node.left, x)
				if x on right of node, return node.leftSize() + 1 + getRank(node.right, x)
	}
	*/
	RankNode root = null;
	
	void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert(number);
		}
	}
	
	public class RankNode {
		public int left_size = 0;
		public RankNode left, right;
		public int data = 0;
		public RankNode(int d) {
			data = d;
		}
		
		public void insert(int d) {
			if (d <= data) {
				if (left != null) left.insert(d);
				else left = new RankNode(d);
				left_size++;
			} else {
				if (right != null) right.insert(d);
				else right = new RankNode(d);
			}
		}
		
		public int getRank(int d) {
			if (d == data) {
				return left_size;
			} else if (d < data) {
				if (left == null) return -1;
				else return left.getRank(d);
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1) return -1;
				else return left_size + 1 + right_rank;
			}
		}
	}
}

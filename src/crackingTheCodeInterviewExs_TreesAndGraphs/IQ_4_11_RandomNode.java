package crackingTheCodeInterviewExs_TreesAndGraphs;

import java.util.Random;

public class IQ_4_11_RandomNode {

	// Option #1 Slow & Working
	// Option #2 Slow & Working
	// Option #3 Slow & Working
	// Option #4 Fast & Not Working
	// Option #5 Fast & Not Working
	// Option #6 Fast & Working
	class TreeNode {
		private int data;
		public TreeNode left;
		public TreeNode right;
		private int size = 0;
		
		public TreeNode(int d) {
			data = d;
			size = 1;
		}
		
		public TreeNode getRandomNode() {
			int leftSize = left == null ? 0 : left.size();
			Random random = new Random();
			int index = random.nextInt(size);
			if (index < leftSize) {
				return left.getRandomNode();
			} else if (index == leftSize) {
				return this;
			} else {
				return right.getRandomNode();
			}
		}
		
		public void insertInOrder(int d) {
			if (d <= data) {
				if (left == null) {
					left = new TreeNode(d);
				} else {
					left.insertInOrder(d);
				}
			} else {
				if (right == null) {
					right = new TreeNode(d);
				} else {
					right.insertInOrder(d);
				}
			}
			size++;
		}
		
		public TreeNode find(int d) {
			if (d == data) {
				return this;
			} else if (d <= data) {
				return left != null ? left.find(d) : null;
			} else if (d > data) {
				return right != null ? right.find(d) : null;
			}
			return null;
		}
	}
	
}

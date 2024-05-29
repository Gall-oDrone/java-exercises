package crackingTheCodeInterviewExs_TreesAndGraphs;

public class IQ_4_5_ValidateBST {
	// Solution #1: In-Order Traversal
	int index = 0;
	void copyBST(TreeNode root, int[] array) {
		if (root == null) return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}
	
	boolean checkBST(TreeNode root) {
		int[] array = new int[root.size];
		copyBST(root, array);
		for (int i=1; i < array.length; i++) {
			if (array[i] <= array[i - 1]) return false;
		}
		return true;
	}
	
	// Optimized implementation
	Integer last_printed = null;
	boolean checkBST(TreeNode n) {
		if (n == null) return true;
		
		// Check / recurse left
		if (!checkBST(n.left)) return false;
		
		// Check current
		if (last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right)) return false;
		
		return true; // All good!
	}
	
	class WrapInt {
		public int value;
	}
	
	// Solution #2: The Min / Max Solution
	boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
}

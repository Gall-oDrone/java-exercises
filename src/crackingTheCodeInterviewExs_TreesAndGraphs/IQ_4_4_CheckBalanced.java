package crackingTheCodeInterviewExs_TreesAndGraphs;

import javax.swing.tree.TreeNode;

public class IQ_4_4_CheckBalanced {
	int getHeight(TreeNode root) {
		if (root == null) return -1; // Base case
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	boolean isBalanced(TreeNode root ) {
		if (root == null) return true; // Base case
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else { // Recurse
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	// Optimized implementation runs in O(N) time and O(H) space, where 'H' -> height of the tree
	int checkHeight(TreeNode root) {
		if (root == null) return -1;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
}

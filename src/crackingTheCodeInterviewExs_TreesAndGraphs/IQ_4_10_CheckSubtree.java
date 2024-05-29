package crackingTheCodeInterviewExs_TreesAndGraphs;

import javax.swing.tree.TreeNode;

public class IQ_4_10_CheckSubtree {
	boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		
		return string1.indexOf(string2.toString()) != -1;
	}
	
	void getOrderString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X"); // Add null indicator
			return;
		}
		sb.append(node.data + " "); // Add root
		getOrderString(node.left, sb); // Add left
		getOrderString(node.right, sb); // Add right
	}
	
	// Alternative approach
	boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) return true; // THe empty tree is always a subtree
		return subTree(t1,t2);
	}
	
	boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false; // big tree empty & subtree still not found.
		} else if (r1.data == r2.data && matchTree(r1, r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}
	
	boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 ==null) {
			return true; // nothing left in the subtree
		} else if (r1 == null || r2 ==null) {
			return false; // exactly tree is empty, therefore trees don't match
		} else if (r1.data != r2.data) {
			return false; // data doesn't match
		} else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}
}

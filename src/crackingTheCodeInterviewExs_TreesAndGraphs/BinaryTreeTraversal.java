package crackingTheCodeInterviewExs_TreesAndGraphs;

public class BinaryTreeTraversal {
	
	/* In-Order Traversal */
	void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}
	
	/* Pre-Order Traversal */
	void preORderTraversal(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	/* Post-Order Traversal */
	void postOrderTraversal(TreeNode node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			visit(node);
		}
	}
	
	
}

package crackingTheCodeInterviewExs_TreesAndGraphs;

import javax.swing.tree.TreeNode;

public class IQ_4_6_Successor {
	TreeNode inorderSucc(TreeNode n) {
		if (n == null) return null;
		/* Found right children -> return leftmost node of right subtree. */
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.getParent();
			// Go up until we're on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
}

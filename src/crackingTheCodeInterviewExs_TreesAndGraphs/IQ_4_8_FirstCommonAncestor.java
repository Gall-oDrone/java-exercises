package crackingTheCodeInterviewExs_TreesAndGraphs;

import javax.swing.tree.TreeNode;

public class IQ_4_8_FirstCommonAncestor {
	
	/* Solution #1: With Links to Parents */
	TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int delta = depth(p) - depth(q); // get difference in depths
		TreeNode first = delta > 0 ? q : p; // get shallower node
		TreeNode second = delta > 0 ? p : q; // get deeper node
		second = goUpBy(second, Math.abs(delta)); // move deeper node up
		
		/* Find where path intersect. */
		while (first != second && first != null && second != null) {
			first = first.getParent();
			second = second.getParent();
		}
		return first == null || second == null ? null : first;
	}
	
	TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.getParent();
			delta--;
		}
		return node;
	}
	
	int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.getParent();
			depth++;
		}
		return depth;
	}
	
	/* Solution #2: With Links to Parents (Better Worst-Case Runtime) */
	TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		/* Check if either node is not in the three, or if one covers the other. */
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}
		
		/* Traverse upwards until you find a node that coers q. */
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.getParent();
		while (!covers(sibling,q)) {
			sibling = getSibilng(parent);
			parent = parent.getParent();
		}
		return parent;
	}
	
	boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		
		TreeNode parent = node.getParent();
		return parent.left == node ? parent.right : parent.left;
	}
	
	/* Solution #3: Without Links to Parents */
	/* Runs in O(n) tiem on a balanced tree */
	TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		/* Error check - one node is not in the tree. */
		if (!covers3(root, p) || !covers3(root, q)) {
			return null;
		}
		return ancestorHelper(root, p, q);
	}
	
	TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		boolean pIsOnLeft = covers3(root.left, p);
		boolean qIsOnLeft = covers3(root.left, q);
		if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
			return root;
		}
		TreeNode childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}
	
	boolean covers3(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers3(root.left, p) || covers3(root.right, p);
	}
	
	/* Solution #4: Optimized */
	/* Runs in O(n) time on a balanced tree */
	/* The below code has a bug. */
	TreeNode commonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p && root == q) return root;
		
		TreeNode x = commonAncestor4(root.left, p, q);
		if (x != null && x != p && x != q) { // Already found ancestor
			return x;
		}
		
		TreeNode y = commonAncestor4(root.right, p, q);
		if (y != null && y != p && y != q) { // Already found ancestor
			return y;
		}
		
		if (x != null && y != null) { // p and q found in diff. subtrees
			return root; // This is the common ancestor
		} else if (root == p || root == q) {
			return root;
		} else {
			return x == null ? y : x; /* return the non-null value */
		}
	}
	
	class Result {
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}
	
	TreeNode commonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper4(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}
	
	Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return new Result(null, false);
		
		if (root == p && root == q) {
			return new Result(root, true);
		}
		
		Result rx = commonAncHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}
		
		Result ry = commonAncHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}
		
		if ( rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/* If we're currently at p or q, and we also found one of those node in a
			 * subtree, then this is truly an ancestor and the flag should be true.
			 */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}
}

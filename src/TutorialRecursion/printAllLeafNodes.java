package TutorialRecursion;

import java.util.List;

public class printAllLeafNodes {
	
	public static void main(String[] args) {
		List<Integer> dataInput = 
				List.of(100,80,5090,30,60,90,85,95,120,110,108,115,140,150);
		Node root = null;
		for (Integer node : dataInput ) {
			root = insertNode(root, node);
		}
		printLeaves(root);
	}
	
	public static void printLeaves(Node root) {
		if(root == null) return;
		
		if (root.left == null && root.right == null) {
			System.out.print(root.val + ", ");
			return;
		}
		if(root.left != null)
			printLeaves(root.left);
		if(root.right != null)
			printLeaves(root.right);
	}
}

package DepthFirst;

import java.util.Stack;

import javafx.scene.Node;

public class ex1 {

	public static void main(String[] args) {
	}
	
	public void traversePreOrder(Node node) {
		if (node != null) {
			visit(node.value);
			traversePreORder(node.left);
			traversePreORder(node.right);
		}
	}
	
	public void traversePreOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			current = stack.pop();
			visit(current.value);
			
			if(current.right != null) {
				stack.push(current.right);
			}
			if(current.left != null) {
				stack.push(current.left);
			}
		}	
	}
	
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			visit(node.value);
			traverseInOrder(node.right);
		}
	}
	
	public void traverseInOrderWithoutRecursion() {
		Stack stack = new Stack <>();
		Node current = root;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
		}
	}
}

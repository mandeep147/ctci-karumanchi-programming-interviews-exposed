package edu.mandeep.karumanchi.trees;

import java.util.Stack;

public class TreeTraversalIterative {

	private static void InOrder(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		int flag = 0;		
		while(flag != 1 ){
			if( current != null){
				stack.push(current);
				current = current.left;
			} 
			else{
				if(stack.isEmpty()){
					flag = 1;
				}
				else{
					current = stack.pop();
					System.out.print(current.data+ " ");
					current = current.right;
				}
			}
		}
	}

	private static void PreOrder(TreeNode root) {	
		if( root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.data + " ");		
			if(node.right != null)
				stack.push(node.right);		
			if(node.left != null)
				stack.push(node.left);
		}
	}

	private static void PostOrder(TreeNode root) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args){
		TreeNode root = CreateTree.createTree();
		System.out.print("Pre-Order Traversal: ");
		PreOrder(root);

		System.out.print("\nIn-Order Traversal: ");
		InOrder(root);

		System.out.print("\nPost-Order Traversal: ");
		PostOrder(root);

	}
}
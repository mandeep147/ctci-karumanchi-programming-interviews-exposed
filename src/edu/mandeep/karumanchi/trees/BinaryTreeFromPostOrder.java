/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.Scanner;

/**
 * Problem 30: construct binary tree from given inorder and preorder traversals
 * input: inorder: D B E A F C
 * 		  preorer: A B D E C F
 * @author mandeep
 *
 */
public class BinaryTreeFromPostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		inputTreeTraversals();
	}
	
	public static void inputTreeTraversals(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of tree nodes: ");
		int n = in.nextInt();
		System.out.println("Enter post order traversal: ");
		int[] postorder = new int[n];
		int[] inorder = new int[n];
		for(int i = 0; i < n; i++)
			postorder[i] = in.nextInt();
		System.out.println("Enter in order traversal: ");
		for(int i = 0; i < n; i++)
			inorder[i] = in.nextInt();
		
		in.close();
		System.out.print("Level-Order Traversal: ");
		LevelOrderTraversal.LevelOrder(buildTree(postorder, inorder));
		System.out.print("In-Order Traversal: ");
		TreeTraversalRecursive.InOrder(buildTree(postorder, inorder));
	}

	private static TreeNode buildTree(int[] postorder, int[] inorder) {
		if(postorder.length == 0 || inorder.length != postorder.length)
			return null;
		
		return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
		if(postStart > postEnd || inStart > inEnd)
			return null;
		
		int root = postorder[postEnd];
		TreeNode current = new TreeNode(root);
		int i = inStart;
		for(; i < inEnd; i++){
			if(inorder[i] == root)
				break;
		}
		
		current.left = buildTree(postorder, postStart, postStart + i - inStart - 1, inorder, inStart, i - 1);
		current.right = buildTree(postorder, postStart + i - inStart, postEnd - 1, inorder, i + 1, inEnd);
		return current;
	}
}
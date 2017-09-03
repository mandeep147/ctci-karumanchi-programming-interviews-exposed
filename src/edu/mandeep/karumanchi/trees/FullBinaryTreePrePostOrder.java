/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.Scanner;

/**
 * Given two arrays that represent preorder and postorder traversals of a full binary tree,
 * construct the binary tree.
 * Input:  Preorder: {1, 2, 4, 8, 9, 5, 3, 6, 7} 
 * 			Postorder: {8, 9, 4, 5, 2, 6, 7, 3, 1}
 * 
 * geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * @author mandeep
 *
 */
public class FullBinaryTreePrePostOrder {
	private static int loc = 0;

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
		int[] preorder = new int[n];
		for(int i = 0; i < n; i++)
			postorder[i] = in.nextInt();
		System.out.println("Enter pre order traversal: ");
		for(int i = 0; i < n; i++)
			preorder[i] = in.nextInt();
		
		System.out.print("In-Order Traversal: ");
		TreeTraversalRecursive.InOrder(buildTree(postorder, preorder));
	}
	
	private static TreeNode buildTree(int[] postorder, int[] preorder) {
		if(postorder.length == 0 || preorder.length != postorder.length)
			return null;
		
		return buildTree(preorder, postorder, 0, postorder.length - 1);
	}
	
	private static TreeNode buildTree(int[] preorder, int[] postorder, int start, int end) {
		if(start > end)
			return null;
		
		int root = postorder[end];
		TreeNode current = new TreeNode(root);
		loc++;
		
		if(start == end)
			return current;
		
		int index = 0;
		
		for(; index < postorder.length; index++){
			if(postorder[index] == preorder[loc])
				break;
		}
		
		current.left = buildTree(preorder, postorder, start, index);
		current.right = buildTree(preorder, postorder, index + 1, end - 1);
		
		return current;
	}
}
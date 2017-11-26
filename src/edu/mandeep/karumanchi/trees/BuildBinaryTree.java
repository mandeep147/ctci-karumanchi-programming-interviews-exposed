/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.Scanner;

/**
 * Problem 29: construct binary tree from given inorder and preorder traversals
 * input: inorder: D B E A F C
 * 		  preorer: A B D E C F
 * @author mandeep
 *
 */
public class BuildBinaryTree {

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
		System.out.println("Enter pre order traversal: ");
		int[] preorder = new int[n];
		int[] inorder = new int[n];
		for(int i = 0; i < n; i++)
			preorder[i] = in.nextInt();
		System.out.println("Enter in order traversal: ");
		for(int i = 0; i < n; i++)
			inorder[i] = in.nextInt();
		
		//buildTree(preorder, inorder);
		in.close();
		System.out.print("Level-Order Traversal: ");
		LevelOrderTraversal.LevelOrder(buildTree(preorder, inorder));
		System.out.print("\nIn-Order Traversal: ");
		TreeTraversalRecursive.InOrder(buildTree(preorder, inorder));
	}
	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length != preorder.length)
			return null;
		
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
		if(preStart > preEnd || inStart > inEnd)
			return null;
		
		int root = preorder[preStart];
		TreeNode current = new TreeNode(root);
		int i = inStart;
		for(; i < inEnd; i++){
			if(inorder[i] == root)
				break;
		}
		
		current.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
		current.right = buildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
		return current;
	}
}
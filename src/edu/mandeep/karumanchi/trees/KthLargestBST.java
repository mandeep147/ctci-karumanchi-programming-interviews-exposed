/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.Scanner;

/**
 * Problem 64: Given a Binary Search Tree (BST) and a positive integer k, 
 * find the k'th largest and k'th smallest element in the Binary Search Tree.
 * @author mandeep
 */
public class KthLargestBST {
	
	private static int count = 0;

	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * @param args
	 */
	public static void main(String[] args) {
		inputTreeTraversals();
	}
	
	public static void inputTreeTraversals(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of tree nodes: ");
		int n = in.nextInt();
		System.out.println("Enter node values: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		
		System.out.println("Enter value of k: ");
		int k = in.nextInt();
		
		//System.out.print("In-Order Traversal: ");
		//TreeTraversalRecursive.InOrder(buildBST(arr));
		TreeNode root = buildBST(arr);
		kthLargestElement(root, k);
		count = 0;
		kthSmallestElement(root, k);
	}
	
	public static TreeNode buildBST(int[] arr) {
		if (arr.length == 0)
			return null;
 
		return buildBST(arr, 0, arr.length - 1);
	}
 
	public static TreeNode buildBST(int[] arr, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildBST(arr, start, mid - 1);
		root.right = buildBST(arr, mid + 1, end);
		return root;
	}
	
	private static TreeNode kthLargestElement(TreeNode root, int k){
		
		if(root == null)
			return null;
		
		kthLargestElement(root.right, k);
		
		if(++count == k)
			System.out.println(k+"th largest element is: "+root.data);
		
		return kthLargestElement(root.left, k);
	}
	
	private static TreeNode kthSmallestElement(TreeNode root, int k){
		if(root == null)
			return null;
		
		kthSmallestElement(root.left, k);
		
		if(++count == k)
			System.out.println(k+"th smallest element is: "+root.data);
		
		return kthSmallestElement(root.right, k);
	}
	
}
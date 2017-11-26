/**
 * Problem 4.2: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a BST woth minimal height.
 */
package edu.mandeep.ctci.treesAndGraphs;

/**
 * @author mandeep
 *
 */
public class MinimalTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = createBST(arr);
		System.out.print("Level-Order Traversal: ");
		CreateTree.LevelOrder(root);
	}
	
	/**
	 * @param arr
	 * @return
	 */
	private static TreeNode createBST(int[] arr) {
		if(arr.length == 0)
			return null;
		
		return createBST(arr, 0, arr.length - 1);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static TreeNode createBST(int[] arr, int start, int end) {
		if(end < start)
			return null;
		int mid = (start + end) / 2;
		
		TreeNode node = new TreeNode(arr[mid]);
		
		node.left = createBST(arr, start, mid - 1);
		node.right = createBST(arr, mid + 1, end);
		
		return node;
	}

}
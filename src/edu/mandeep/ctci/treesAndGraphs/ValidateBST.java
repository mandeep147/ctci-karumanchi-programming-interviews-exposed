/**
 * Problem 4.5: check if a binary tree is a BST
 */
package edu.mandeep.ctci.treesAndGraphs;

/**
 * @author mandeep
 *
 */
public class ValidateBST {

	private static Integer lastPrinted = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("given tree is a BST?: "+validateBST(root));
		System.out.println("given tree is a BST?: "+checkBST(root));
	}

	/**
	 * Time: O(n)
	 * Space: O(log n) due to recursion
	 * @param root
	 * @return
	 */
	private static boolean checkBST(TreeNode root) {
		return checkBST(root, null, null);
	}

	/**
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean checkBST(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		
		if((min != null && root.data <= min ) ||(max !=  null && root.data > max))
			return false;
		
		if(!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max))
			return false;
		
		return true;
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean validateBST(TreeNode root) {
		if(root == null)
			return true;
		if(!validateBST(root.left))
			return false;
		
		if(lastPrinted != null && root.data <= lastPrinted)
			return false;
		
		lastPrinted = root.data;
		
		if(!validateBST(root.right))
			return false;
		
		return true;
	}

	
}
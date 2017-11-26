/**
 * Problem 4.4: Check if a binary tree is balanced.
 */
package edu.mandeep.ctci.treesAndGraphs;

/**
 * @author mandeep
 *
 */
public class CheckBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("tree is balanced? : "+isBalanced(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int diff = getTreeHeight(root.left) - getTreeHeight(root.right);
		if(Math.abs(diff) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	/**
	 * @param left
	 * @return
	 */
	private static int getTreeHeight(TreeNode root) {
		if(root == null)
			return -1;
		return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
	}

}
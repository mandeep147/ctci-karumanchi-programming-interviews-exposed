/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 6: Size of binary tree
 * Problem 7: without recursion
 * @author mandeep
 *
 */
public class SizeOfBinaryTree {

	/** Space = Time= O(n)
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println(sizeOfTreeRecursive(root));
		System.out.println(sizeOfTree(root));
		
		System.out.println(sum(root));
	}
	
	private static int sizeOfTreeRecursive(TreeNode root){
		int leftCount = root.left == null? 0 : sizeOfTreeRecursive(root.left);
		int rightCount = root.right == null? 0 : sizeOfTreeRecursive(root.right);
		return leftCount + rightCount +1;		
	}
	
	//level order traversal
	private static int sizeOfTree(TreeNode root){
		int count = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty()){
			TreeNode current = que.poll();
			count++;
			if(current.getLeft() != null)
				que.offer(current.getLeft());
			if(current.getRight() != null)
				que.offer(current.getRight());
		}
		return count;
	}
	
	private static int sum(TreeNode root){
		int leftCount = 0, rightCount = 0;
		if(root.left != null)
			leftCount += sum(root.left);
		if(root.right != null)
			rightCount += sum(root.right);
		return leftCount + rightCount + root.data;		
	}
}
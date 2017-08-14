/**
 * 
 */
package edu.mandeep.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mandeep
 * Problem 3: search an element in binary tree
 * Problem 4: without recursion
 */
public class SearchElement {

	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println(searchElement(root, 4));
		System.out.println(searchElement(root, 0));
		System.out.println(searchElement(root, 14));
		
		System.out.println(searchElementIterative(root, 4));
		System.out.println(searchElementIterative(root, 14));
		System.out.println(searchElementIterative(root, 0));
	}
	
	public static boolean searchElement(TreeNode root, int data){
		if(root == null)
			return false;
		if(root.getData() == data)
			return true;
		return searchElement(root.getLeft(), data) || searchElement(root.getRight(), data);
	}
	
	public static boolean searchElementIterative(TreeNode root, int data){
		//level order traversal
		if(root == null)
			return false;
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty()){
			TreeNode current = que.poll();
			if(current.getData() == data)
				return true;
			if(current != null) {
				if(current.getLeft() != null)
					que.offer(current.getLeft());
				if(current.getRight() != null)
					que.offer(current.getRight());
			}
		}
		return false;
	}
}
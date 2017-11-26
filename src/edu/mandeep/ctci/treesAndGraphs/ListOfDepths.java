/**
 * Problem 4.3: Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
 */
package edu.mandeep.ctci.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author mandeep
 *
 */
public class ListOfDepths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.println("using DFS approach");
		ArrayList<LinkedList<TreeNode>> depth = depthLinkedList(root);
		for (int i = 0; i < depth.size(); i++) {
			for(TreeNode str : depth.get(i))
				System.out.print(str.data+" ");
			System.out.println();
		}
		
		System.out.println("\nusing BFS approach");
		ArrayList<LinkedList<TreeNode>> depthBFS = createLinkedLists(root);
		for (int i = 0; i < depthBFS.size(); i++) {
			for(TreeNode str : depthBFS.get(i))
				System.out.print(str.data+" ");
			System.out.println();
		}
	}

	/**
	 * using DFS
	 * extra space: O(log n) for recursion
	 * Time: O(n)
	 * @param root
	 * @return
	 */
	public static ArrayList<LinkedList<TreeNode>> depthLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		depthLinkedList(root, lists, 0);
		return lists;
	}

	/**
	 * @param root
	 * @param lists
	 * @param i
	 */
	private static void depthLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root == null)
			return;
		
		LinkedList<TreeNode> list = null;
		
		if(lists.size() == level){ 	//level is not in the list
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else
			list = lists.get(level);
		
		list.add(root);
		depthLinkedList(root.left, lists, level+1);
		depthLinkedList(root.right, lists, level+1);	
	}
	
	/**
	 * using BFS approach
	 * Time: O(n)
	 * @param root
	 * @return
	 */
	public static ArrayList<LinkedList<TreeNode>> createLinkedLists(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null)
			current.add(root);
		
		while(current.size() > 0){
			lists.add(current);						//add previous level to list
			LinkedList<TreeNode> parents = current; //traverse to next level
			current = new LinkedList<TreeNode>();
			
			for(TreeNode parent : parents){
				if(parent.left != null)
					current.add(parent.left);
				
				if(parent.right != null)
					current.add(parent.right);
			}
		}
		return lists;
	}
}
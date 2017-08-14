package edu.mandeep.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElement {
	
	public static int maximumElement(TreeNode root){
		
		if(root == null)
			return 0;
		
		int max = root.data;
		
		if( root.left != null)
			max = Math.max(max, maximumElement(root.left));
		
		if( root.right != null)
			max = Math.max(max, maximumElement(root.right));
		
		return max;
	}
	
	public static int maxElementIterative(TreeNode root){
		
		if( root == null){
			System.out.println("Tree is empty");
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int max = root.data;
		
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			
			if( max < current.data)
				max = current.data;
						
			if(current.left != null)
				queue.offer(current.left);
				
			if(current.right != null)
				queue.offer(current.right);			
		}		
		return max;
	}

	public static void main(String[] args){
		TreeNode root = CreateTree.createTree();
		System.out.println("Max Element (Recursive Solution) : " +maximumElement(root));
		System.out.println("Max Element (Iterative Solution) : " + maxElementIterative(root));
	}
}
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
		TreeNode root = createTree();
		System.out.println("Max Element (Recursive Solution) : " +maximumElement(root));
		System.out.println("Max Element (Iterative Solution) : " + maxElementIterative(root));
	}
	
	public static TreeNode createTree(){
		TreeNode root = new TreeNode(10);
		TreeNode node2=new TreeNode(4);  
		  TreeNode node3=new TreeNode(13);  
		  TreeNode node4=new TreeNode(42);  
		  TreeNode node6=new TreeNode(36);  
		  TreeNode node5=new TreeNode(5);  
		  TreeNode node7=new TreeNode(7);  
		    
		  root.left=node2;  
		  root.right=node3;  
		    
		  node2.left=node4;  
		  node2.right=node5;  
		    
		  node3.left=node6;  
		  node3.right=node7;  
		    
		  return root;
	}
}
package edu.mandeep.karumanchi.trees;

public class TreeTraversalRecursive {
	public static void PreOrder(TreeNode root){
		if(root != null){
			System.out.print(root.data+ " ");
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}
	
	public static void PostOrder(TreeNode root){
		if(root != null){
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.data+ " ");
		}
	}
	
	public static void InOrder ( TreeNode root ){
		if(root != null){
			InOrder(root.left);
			System.out.print(root.data+ " ");
			InOrder(root.right);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = createTree();
		System.out.print("Pre-Order Traversal: ");
		PreOrder(root);
		
		System.out.print("\nIn-Order Traversal: ");
		InOrder(root);

		System.out.print("\nPost-Order Traversal: ");
		PostOrder(root);
	}
	
	public static TreeNode createTree(){
		TreeNode root = new TreeNode(1);
		TreeNode node2=new TreeNode(2);  
		  TreeNode node3=new TreeNode(3);  
		  TreeNode node4=new TreeNode(4);  
		  TreeNode node6=new TreeNode(6);  
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

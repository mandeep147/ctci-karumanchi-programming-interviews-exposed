
/**
 *incomplete 
 */
package edu.mandeep.karumanchi.trees;

/**
 * @author mandeep
 *
 */
public class BinarySearchTree {
	
	class Node {
        int key;
        Node left, right;
 
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
 
    Node root;
 
    public BinarySearchTree() { 
        root = null; 
    }
	
	//insert an element 
	public TreeNode Insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		}else{
			if(data < root.getData())
				root.setLeft(Insert(root.getLeft(), data));
			else if(data > root.getData())
				root.setRight(Insert(root.getRight(), data));
		}
		return root;
	}
	
	public static void main(String[] args) {
		
	}
}
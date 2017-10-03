/**
 * 
 */
package edu.mandeep.karumanchi.linkedList;

/**
 * @author mandeep
 *
 */
public class Node {
	public Node next;
	public int data;

	public Node(){
		next = null;
		data = 0;
	}

	public Node(int data){
		this.data = data;
		next = null;
	}

	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}
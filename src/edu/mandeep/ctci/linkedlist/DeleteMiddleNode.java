/**
 * Problem 2.3: delete a node in the middle of a singly linked list, given only access to that node.
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class DeleteMiddleNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(10);
		Node next = new Node(11);
		Node third = new Node(12);
		Node fourth = new Node(13);
		Node fifth = new Node(14);
		
		start.next = next;
		next.next = third;
		third.next = fourth;
		fourth.next = fifth;
		Node.printList(start);
		deleteNode(third);
		Node.printList(start);
		
	}

	private static boolean deleteNode(Node current){
		if(current == null || current.next == null)
			return false;
		
		Node next = current.next;
		current.data = next.data;
		current.next = next.next;
		return true;
	}
}
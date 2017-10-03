/**
 * Problem 2.1: Remove Dups
 * remove duplicates from unsorted linked list (without temp buffer)
 */
package edu.mandeep.ctci.linkedlist;
import java.util.HashSet;

/**
 * @author mandeep
 *
 */
public class RemoveDups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(10);
		start.appendToTail(12);
		start.appendToTail(11);
		start.appendToTail(11);
		start.appendToTail(12);
		start.appendToTail(11);
		start.appendToTail(10);
	    Node.printList(start);
	    removeDuplicate(start);
	    Node.printList(start);
	    removeDups(start);
	    Node.printList(start);
	}
	
	
	/**
	 * Complexity: O(pow(n,2))
	 * Space: O(1)
	 * @param head
	 */
	private static void removeDuplicate(Node head){
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}
	
	/**
	 * Complexity: O(n)
	 * @param head
	 */
	private static void removeDups(Node head){
		HashSet<Integer> set = new HashSet<>();
		Node prev = null;
		while(head != null){
			if(set.contains(head.data))
				prev.next = head.next;
			else{
				set.add(head.data);
				prev = head;
			}
			head = head.next;
		}
	}
}
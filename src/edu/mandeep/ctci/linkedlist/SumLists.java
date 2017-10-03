/**
 * Problem 2.5: 
 * You have two numbers represented by linked list, where each node contains
 * a single digit. Digits are stored in reverse order.(1's digit is at the head)
 * Write a function that adds two such numbers and returns a number in similar
 * list format.
 * example:
 * 7-->1-->6 + 5-->9-->2 = 2-->1-->9
 * which is (617 + 295  = 912)
 * What if digits are not stored in reverse order(i.e 1's digit is at tail)
 * (6--1-->7) + (2-->9-->5) = (9-->1-->2)
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class SumLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(7);
		start.appendToTail(1);
		start.appendToTail(6);
		
		Node second = new Node(5);
		second.appendToTail(9);
		second.appendToTail(2);
		
		Node.printList(start);
		Node.printList(second);
		Node.printList(addLists(start, second, 0));
	}
	
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return
	 */
	private static Node addLists(Node l1, Node l2, int carry){
		
		if(l1 == null && l2 == null && carry == 0)
			return null;
		
		Node result = new Node();
		int value = carry;
		if(l1 != null)
			value += l1.data;
		
		if(l2 != null)
			value += l2.data;
		
		result.data = value % 10; 
		
		if(l1 != null || l1 != null){
			Node more = addLists(l1 == null? null : l1.next, l2 == null? null : l2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
}

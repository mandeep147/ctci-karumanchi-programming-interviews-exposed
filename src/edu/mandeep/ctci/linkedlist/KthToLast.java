/**
 * Problem: 2.2 find kth to last element of a singly linked list
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class KthToLast {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(10);
		start.appendToTail(12);
		start.appendToTail(11);
		start.appendToTail(13);
		start.appendToTail(15);
		start.appendToTail(9);
		start.appendToTail(16);
		
		printKthElement(start, 3);
		Node kth = kthToLast(start, 3);
		System.out.println(kth.data);
	}
	
	/**
	 * recursive solution
	 * traverses the linkedlist recursively. When end is reached, counter is set to 0
	 * Each parent call adds 1 to counter, when counter == k element value is printed back.
	 * Space Complexity: O(n) due to recursive calls
	 * @param head
	 * @param k
	 * @return
	 */
	private static int printKthElement(Node head, int k){
		if(head == null)
			return 0;
		int index = printKthElement(head.next, k) + 1;
		if(index == k)
			System.out.println(k + "th to last element is: " + head.data);
		return index;	
	}
	
	/**
	 * Iterative solution
	 * use 2 pointers, p1 & p2, start p1 from kth node and p2 from 0 when p1 is at end, p2 will be at kth element
	 * Space Complexity: O(1)
	 * Time Complexity: O(n)
	 * @param head
	 * @param k
	 * @return
	 */
	private static Node kthToLast(Node head, int k){
		Node p1 = head;
		Node p2 = head;
		
		// Move p1 k nodes into the list
		for(int i = 0; i < k; i++){
			if(p1 == null)
				return null;
			p1 = p1.next;
		}
		
		//Move at same pace, when p1 hits end, p2 will be at the right element
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
}
/**
 * Problem 2.6: check if a linkedlist is a pallindrome
 */
package edu.mandeep.ctci.linkedlist;

import java.util.Stack;

/**
 * @author mandeep
 *
 */
public class Pallindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(3);
		start.appendToTail(5);
		start.appendToTail(8);
		start.appendToTail(5);
		start.appendToTail(8);
		start.appendToTail(5);
		start.appendToTail(3);
		
		Node.printList(start);
		
		System.out.println("linked list is pallindrome?: "+isPallindrome(start));
		System.out.println("linked list is pallindrome?: "+checkPallindrome(start));
	}

	//----------------------Method - 1 Reverse and Compare------------------------------
	/**
	 * @param start
	 * @return
	 */
	private static boolean isPallindrome(Node start) {
		Node reverse = reverseAndDuplicate(start);
		return isSame(start, reverse);
	}

	/**
	 * @param start
	 * @param reverse
	 * @return
	 */
	private static boolean isSame(Node start, Node reverse) {
		while(start != null && reverse != null){
			if(start.data != reverse.data)
				return false;
			start = start.next;
			reverse = reverse.next;
		}
		return start == null && reverse == null;
	}

	/**
	 * @param start
	 * @return
	 */
	private static Node reverseAndDuplicate(Node start) {
		Node head = null;
		while(start != null){
			Node node = new Node(start.data);
			node.next = head;
			head = node;
			start = start.next;
		}
		return head;
	}
	
	//----------------------Method - 2 Iterative------------------------------
	private static boolean checkPallindrome(Node head){
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null)
			slow = slow.next;
		
		while(slow != null){
			int top = stack.pop().intValue();
			
			if(top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
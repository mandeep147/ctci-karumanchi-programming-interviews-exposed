/**
 * Problem 2.5: 
 * You have two numbers represented by linked list, where each node contains
 * a single digit. 
 * digits are not stored in reverse order(i.e 1's digit is at tail)
 * (6--1-->7) + (2-->9-->5) = (9-->1-->2)
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class SumListsPartB {

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
	 * @param start
	 * @param second
	 * @param i
	 * @return
	 */
	private static Node addLists(Node l1, Node l2, int carry) {
		int len1 = Node.length(l1);
		int len2 = Node.length(l2);
		
		/**
		 * Pad shorter lists with 0s
		 */
		if(len1 < len2)
			l1 = padList(l1, len2 - len1);
		else
			l2 = padList(l2, len1 - len2);
		
		//Add lists
		PartialSum sum = addListsHelper(l1, l2);
		
		if(sum.carry == 0)
			return sum.sum;
		else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	/**
	 * @param sum
	 * @param carry
	 * @return
	 */
	private static Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if(list != null)
			node.next = list;
		return node;
	}

	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static PartialSum addListsHelper(Node l1, Node l2) {
		if(l1 == null && l2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		
		Node finalNode = insertBefore(sum.sum, val % 10);
		sum.sum = finalNode;
		sum.carry = val / 10;
		
		return sum;
	}

	/**
	 * @param l1
	 * @param i
	 * @return
	 */
	private static Node padList(Node l1, int pad) {
		Node head = l1;
		
		for(int i = 0; i < pad; i++)
			head = insertBefore(head, 0);
		return head;
	}
}

class PartialSum{
	public Node sum = null;
	public int carry = 0;
}
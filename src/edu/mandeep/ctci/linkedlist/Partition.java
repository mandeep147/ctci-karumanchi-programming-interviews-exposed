/**
 * Problem 2.4: partition a linked list around a value of x, s.t all nodes less than x comes before all nodes greater 
 * than or equal to x.
 * input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * output: 3 -> 1-> 2 -> 10 -> 5 -> 5 -> 8
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class Partition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(3);
		start.appendToTail(5);
		start.appendToTail(8);
		start.appendToTail(5);
		start.appendToTail(10);
		start.appendToTail(2);
		start.appendToTail(1);
		
		Node.printList(start);
		Node.printList(partitionList(start, 5));
		Node.printList(start);
		Node.printList(partition(start, 8));
	}
	
	/**
	 * 
	 * @param node
	 * @param x
	 * @return
	 */
	private static Node partitionList(Node node, int x){
		Node head = node;
		Node tail = node;
		
		while(node != null){
			Node next = node.next;
			if(node.data < x){
				node.next = head;
				head = node;
			}else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	private static Node partition(Node node, int x){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		while(node != null){
			Node next = node.next;
			node.next = null;
			if(node.data < x){
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}else{
				if(afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				}else{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if(beforeStart == null)
			return afterStart;
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
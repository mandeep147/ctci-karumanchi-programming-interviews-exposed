/**
 * 
 */
package edu.mandeep.practice.linkedlist;

/**
 * @author mandeep
 *
 */
public class MoveZeroesToBeginning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(3);
		start.appendToTail(1);
		start.appendToTail(0);
		start.appendToTail(2);
		start.appendToTail(0);
		Node.printList(start);
		Node.printList(moveZeroes(start));
	}

	/**
	 * @param start
	 * @return
	 */
	private static Node moveZeroes(Node head) {
		Node currHead = head;
		Node node = head;
		
		while(node.next != null){
			System.out.println(node.data);
			if(node.next.data == 0){
				Node temp = node.next.next;
				currHead = node.next;
				currHead.next = head;
				head = currHead;
				node.next = temp;
			}else
				node = node.next;
		}
		return currHead;
	}

}

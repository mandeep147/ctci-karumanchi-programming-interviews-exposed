/**
 * Problem 2.8: given a circular linked list, return the node at the beginning of the loop
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class LoopDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
		
        Node loop = detectLoop(head);
		System.out.println(loop.data);
	}

	/**
	 * @param head
	 * @return
	 */
	private static Node detectLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			//System.out.println(fast.data +" "+slow.data);
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				break;
		}
		//System.out.println(fast.data +" "+slow.data);
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast){
			//System.out.println(fast.data +" "+slow.data);
			slow = slow.next;
			fast = fast.next;
		}
			
		return fast;
	}

}
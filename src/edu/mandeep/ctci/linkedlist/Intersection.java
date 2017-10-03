/**
 * Problem 2.7: find if given two linked lists intersect and return the intersecting node.
 */
package edu.mandeep.ctci.linkedlist;

/**
 * @author mandeep
 *
 */
public class Intersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = new Node(3);
		start.appendToTail(1);
		start.appendToTail(5);
		start.appendToTail(9);
		start.appendToTail(7);
		start.appendToTail(2);
		start.appendToTail(1);

		Node second = new Node(4);
		second.appendToTail(6);
		second.next = start.next.next.next.next;

		Node.printList(start);
		Node.printList(second);
		
		Node intersect = findIntersectionNode(start, second);
		System.out.println("lists intersect at: "+intersect.data);
	}

	/**
	 * Time Complexity: O(len1 + len2)
	 * Space: O(1)
	 * @param first
	 * @param second
	 * @return
	 */
	private static Node findIntersectionNode(Node first, Node second) {
		if(first == null || second == null)
			return null;
		
		Result r1 = getTailAndLength(first);
		Result r2 = getTailAndLength(second);
		
		if(r1.tail != r2.tail)
			return null;
		
		Node small = r1.size < r2.size ? first : second;
		Node longer = r1.size < r2.size ? second : first;
		
		longer = kthNode(longer, Math.abs(r1.size - r2.size));
		
		while(small != longer){
			small = small.next;
			longer = longer.next;
		}
		
		return longer;
	}
	
	/**
	 * @param longer
	 * @param abs
	 * @return
	 */
	private static Node kthNode(Node head, int k) {
		Node current = head;
		while(k > 0 && current != null){
			current = current.next;
			k--;
		}
		return current;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	static Result getTailAndLength(Node node){
		if(node == null)
			return null;
		
		int size = 1;
		Node current = node;
		
		while(current.next != null){
			size++;
			current = current.next;
		}
		return new Result(current , size);
	}

}

class Result {
	public Node tail;
	public int size;
	
	public Result(Node tail, int size){
		this.tail = tail;
		this.size = size;
	}
}
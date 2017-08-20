/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

import java.util.EmptyStackException;
/**
 * @author mandeep
 *
 */
public class QueueLinkedList<T> {

	class Node<T>{
		private Node<T> next;
		private T data;
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> end;
	
	private T pop() {
		if (head == null)
			throw new EmptyStackException();
		T item = head.data;
		head = head.next;
		return item;
	}
	
	private void push(T data){
		Node<T> queue = new Node<T>(data);
		
		if(end != null){
			end.next = queue;
		}
		
		end = queue;
		
		if(head == null)
			head = end;
	}
	
	private boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		QueueLinkedList<String> theStack = new QueueLinkedList<String>();

		String str = "to be or not to - be - - that - - - is";
		String[] words = str.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			if (words[i].equals("-")) {
				// System.out.println("stack entry: "+theStack.peek());
				System.out.print(theStack.pop() + " ");
			} else
				theStack.push(words[i]);
		}
	}

}

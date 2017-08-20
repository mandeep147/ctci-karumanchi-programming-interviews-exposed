/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

import java.util.EmptyStackException;

/**
 * task: implement stack using linkedlist to take a string and pop element whenever "-" is detected
 * input: "to be or not to - be - - that - - - is";
 * output: "to be not that or be"
 * @author mandeep
 *
 */
public class StacksLinkedList<T> {

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	private T pop() {
		if (top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	private void push(T data) {
		Node<T> nodeT = new Node<T>(data);
		nodeT.next = top;
		top = nodeT;
	}

	@SuppressWarnings("unused")
	private boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		StacksLinkedList<String> theStack = new StacksLinkedList<String>();

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
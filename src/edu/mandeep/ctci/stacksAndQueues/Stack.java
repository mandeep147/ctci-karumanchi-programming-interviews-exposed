/**
 * 
 */
package edu.mandeep.ctci.stacksAndQueues;

import java.util.EmptyStackException;

/**
 * @author mandeep
 *
 */
public class Stack<T> {
	
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data){
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	public T pop(){
		if(top == null)
			throw new EmptyStackException();
		
		T item = top.data;
		top = top.next;
		
		return item;
	}
	
	public void push(T item){
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}
	
	public T peek(){
		if(top == null)
			throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> theStack = new Stack<>();
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		System.out.println(theStack.peek());
		theStack.push(40);
		theStack.push(50);
		while (!theStack.isEmpty()) {
			int value = (int) theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}

}
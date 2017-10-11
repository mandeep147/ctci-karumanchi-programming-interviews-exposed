/**
 * 
 */
package edu.mandeep.ctci.stacksAndQueues;

import java.util.NoSuchElementException;

/**
 * @author mandeep
 *
 */
public class Queue<T> {
	
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data){
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> t = new QueueNode<T>(item);
		if(last != null)
			last.next = t;
		
		last = t;
		if(first == null)
			first = last;
	}
	
	public T remove(){
		if(first == null)
			throw new NoSuchElementException();
		
		T data = first.data;
		first = first.next;
		if(first == null)
			last = null;
		
		return data;
	}
	
	public T peek(){
		if(first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.add(50);
		queue.add(40);
		System.out.println(queue.peek());
		queue.add(30);
		queue.add(20);
		
		queue.add(10);
		
		while(!queue.isEmpty()){
			System.out.print(queue.peek() +" ");
			queue.remove();
		}
		System.out.println(queue.peek());
	}

}
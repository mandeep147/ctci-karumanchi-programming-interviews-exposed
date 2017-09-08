/**
 * 
 */
package edu.mandeep.karumanchi.queues;

import java.util.Stack;

/**
 * Problem-2: Implement a queue using 2 stacks
 * @author mandeep
 *
 */
public class QueueUsingStack<T> {
	
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueUsingStack<Object> q = new QueueUsingStack<>();
		q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(1);
        System.out.println(q.dequeue());
        
        System.out.println(q.dequeue());
	}
	
	private void enqueue(T data){
		s1.push(data);
	}
	
	private T dequeue(){
		while(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}

}
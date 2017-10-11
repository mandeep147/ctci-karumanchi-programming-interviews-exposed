/**
 * Problem 5.5: Queue Via Stacks
 * 
 * Implement Queue class using 2 stacks
 */
package edu.mandeep.ctci.stacksAndQueues;

/**
 * @author mandeep
 *
 */
public class QueueViaStacks {
	
	static class Queue{
		Stack<Integer> s1;
		Stack<Integer> s2;
	}
	
	private static void push(Stack<Integer> top, int x){
		top.push(x);
	}
	
	private static int pop(Stack<Integer> top){
		if(top.isEmpty()){
			System.out.println("Stack overflow");
			System.exit(0);
		}
			
		return top.pop();
	}
	
	private static void enqueue(Queue q, int x){
		push(q.s1, x);
	}
	
	private static int dequeue(Queue q){
		int x;
		
		if(q.s1.isEmpty() && q.s2.isEmpty()){
			System.out.println("Stack overflow");
			System.exit(0);
		}
		
		if(q.s2.isEmpty()){
			while(!q.s1.isEmpty()){
				x = pop(q.s1);
				push(q.s2, x);
			}
		}
		
		x = pop(q.s2);
		return x;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		q.s1 = new Stack<>();
		q.s2 = new Stack<>();
		
		enqueue(q, 1);
		enqueue(q, 2);
		enqueue(q, 3);
		enqueue(q, 4);
		
		System.out.println(dequeue(q)+" ");
		System.out.println(dequeue(q)+" ");
		System.out.println(dequeue(q)+" ");
		//System.out.println(q.s1.peek());
		System.out.println(q.s2.peek());
	}
	
}
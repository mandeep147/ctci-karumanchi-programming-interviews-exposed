/**
 * Problem 5.2: Stack Min
 * design stack to perform push, pop and min operation in O(1) time
 */
package edu.mandeep.ctci.stacksAndQueues;

/**
 * @author mandeep
 *
 */
public class StackMin extends Stack<Integer>{
	
	Stack<Integer> s2;
	
	public StackMin(){
		s2 = new Stack<Integer>();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void push(int value){
		if(value <= min())
			s2.push(value);
		super.push(value);
	}

	/**
	 * 
	 */
	public Integer pop(){
		int value = super.pop();
		
		if(value == min())
			s2.pop();
		return value;
	}
	
	/**
	 * @return
	 */
	private int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else 
			return s2.peek();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackMin s = new StackMin();
		s.push(3);
		s.push(5);
		System.out.println(s.min());
		s.push(2);
		s.push(1);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.peek());
	}
	
}
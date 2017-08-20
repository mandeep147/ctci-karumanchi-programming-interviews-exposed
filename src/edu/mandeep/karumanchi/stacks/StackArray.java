/*
 * implement stack using arrrays
 * 
*/package edu.mandeep.karumanchi.stacks;

public class StackArray {
	
	private int capacity;
	public static int arrayCapacity = 10;
	private int[] arrStack;
	
	private int top = -1;
	
	public StackArray(){
		this(arrayCapacity);
	}
	
	public StackArray(int cap){
		capacity = cap;
		arrStack = new int[capacity];
	}
	
	public int size(){
		return top+1;
	}
	
	public boolean isEmpty(){
			return (top < 0);
	}
	
	public int top() throws Exception{
		if(isEmpty())
			throw new Exception("Stack is empty");
		return arrStack[top];
	}
	
	public void push(int data) throws Exception{
		if(size() == capacity)
			throw new Exception("Stack Overflow");
		
		arrStack[++top] = data;
	}
	
	public int pop() throws Exception{
		int data;
		if(isEmpty())
			throw new Exception("Stack Underflow: Empty Stack");
		data = arrStack[top];
		arrStack[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	  public static void main(String[] args) throws Exception {
	      StackArray theStack = new StackArray(7); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	      theStack.push(40);
	      theStack.push(50);
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	       //  System.out.print(" ");
	      }
	      System.out.println("");
	   }
	
}
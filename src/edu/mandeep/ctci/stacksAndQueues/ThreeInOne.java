/**
 * Problem 3.1. Three in One
 * single array to implement three stacks 
 */
package edu.mandeep.ctci.stacksAndQueues;

import java.util.EmptyStackException;

/**
 * @author mandeep
 *
 */
public class ThreeInOne {
	
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public ThreeInOne(int stackCapacity){
		this.stackCapacity = stackCapacity;
		values = new int[stackCapacity * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	/**
	 * Time Complexity: O(1)
	 * @param value
	 * @param stackNum
	 * @throws StackOverflowError
	 */
	private void push(int value, int stackNum) throws StackOverflowError{
		if(isFull(stackNum))
			throw new StackOverflowError();
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	/**
	 * Time Complexity: O(1)
	 * @param stackNum
	 * @return
	 */
	private int pop(int stackNum){
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum){
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		
		return values[indexOfTop(stackNum)];
	}
	
	/**
	 * @param stackNum
	 * @return
	 */
	private boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	/**
	 * @param stackNum
	 * @return
	 */
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	/**
	 * @param stackNum
	 * @return
	 */
	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		ThreeInOne stack = new ThreeInOne(10);
 
		stack.push(11, 0);
		stack.push(9, 0);
		stack.push(7, 0);
		
		stack.push(17, 1);
		stack.push(49, 1);
		stack.push(39, 1);
 
		stack.push(15, 2);
		stack.push(45, 2);
		
        System.out.println("Popped element from stack 2 is " + stack.pop(2));
        System.out.println("Popped element from stack 1 is " + stack.pop(1));
        System.out.println("Popped element from stack 0 is " + stack.pop(0));
	}

}
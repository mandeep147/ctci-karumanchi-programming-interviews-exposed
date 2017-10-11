/**
 * Problem 5.4: Stack of Plates
 * Implement data structure SetofStacks composed of several stacs and 
 * should create a new stack once the previous one exceeds capacity.
 * 
 * Implement a function popAt(index) which performs a pop operation on a specific sub-stack
 */
package edu.mandeep.ctci.stacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author mandeep
 *
 */
public class StackOfPlates {
	
	ArrayList<NewStack> stacks = new ArrayList<NewStack>();
	public int capacity;
	
	public StackOfPlates(int capacity){
		this.capacity = capacity;
	}
	public void push(int value){
		NewStack last = getLastStack();
		if(last != null && !last.isFull())
			last.push(value);
		else{
			NewStack stack = new NewStack(capacity);
			stack.push(value);
			stacks.add(stack);
		}
	}
	
	public int pop(){
		NewStack last = getLastStack();
		if(last == null)
			throw new EmptyStackException();
		
		int value = last.pop();
		if(last.size == 0)
			stacks.remove(stacks.size() - 1);
		return value;
	}

	/**
	 * @return
	 */
	private NewStack getLastStack() {
		if(stacks.size() == 0)
			return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
	private boolean isEmpty(){
		NewStack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index){
		return leftShift(index, true);
	}

	/**
	 * @param index
	 * @param b
	 * @return
	 */
	private int leftShift(int index, boolean removeTop) {
		NewStack stack = stacks.get(index);
		int removedItem;
		if(removeTop)
			removedItem = stack.pop();
		else
			removedItem = stack.removeBottom();
		
		if(stack.isEmpty())
			stacks.remove(index);
		else if(stacks.size() > index + 1){
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removedItem;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int capacity = 5;
		StackOfPlates set = new StackOfPlates(capacity);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 34; i++) {
			System.out.println("Popped " + set.pop());
		}	
		System.out.println(set.isEmpty());
		System.out.println(set.capacity);
		
		for (int i = 0; i < 10; i++) {
			set.push(i);
		}
		for (int i = 9; i >= 0; i--) {
			System.out.println("Popped " + set.popAt(0));
		}
	}

}

class NewStack{

	public int size = 0;
	private int capacity;
	public Node top, bottom;
	
	/**
	 * @param capacity
	 */
	public NewStack(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return
	 */
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null)
			bottom.below = null;
		size--;
		
		return b.value;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return capacity == size;
	}

	/**
	 * @return
	 */
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		
		return t.value;
	}

	/**
	 * @param value
	 */
	public boolean push(int value) {
		if(size >= capacity)
			return false;
		
		size++;
		Node n = new Node(value);
		
		if(size == 1)
			bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	/**
	 * @param above
	 * @param below
	 */
	private void join(Node above, Node below) {
		if(below != null)
			below.above = above;
		if(above != null)
			above.below = below;
	}
	
}

class Node{
	
	public Node above;
	public Node below;
	public int value;
	
	public Node(int value) {
		this.value = value;
	}
}
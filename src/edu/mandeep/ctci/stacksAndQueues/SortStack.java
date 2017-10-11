/**
 * Problem 3.5: Sort Stack
 * Write a program to sort a stack such that the smallest items are on the top. 
 * Elements can't be copied to other data structure, additional temporary stack can be used.
 * 
 */
package edu.mandeep.ctci.stacksAndQueues;

/**
 * @author mandeep
 *
 */
public class SortStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> input = new Stack<Integer>();
		input.push(34);
		input.push(3);
		input.push(31);
		input.push(98);
		input.push(92);
		input.push(23);

		// This is the temporary stack
		Stack<Integer> temp = sortStack(input);
		System.out.println("Sorted numbers are:");

		System.out.println(temp.peek());
		
		while (!temp.isEmpty()) {
			System.out.print(temp.pop() + " ");
		}
	}

	/**
	 * Complexity: O(n^2)
	 * Space: O(n)
	 * @param input
	 * @return
	 */
	private static Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> temp = new Stack<Integer>();
		while(!input.isEmpty()){
			int x = input.pop();
			while(!temp.isEmpty() && temp.peek() > x){
				input.push(temp.pop());
			}
			
			temp.push(x);
		}
		return temp;
	}

}
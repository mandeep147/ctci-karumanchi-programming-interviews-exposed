/**
 * 
 */
package edu.mandeep.interviewprep;

/**
 * We have an array of integers, where:
 * The integers are in the range 1..n1..n
 * The array has a length of n+1
 * Write a function which finds an integer that appears more than once in our array. 
 * (If there are multiple duplicates, you only need to find one of them.)
 * 
 * https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space-beast-mode
 * @author mandeep
 *
 */
public class DuplicateElementSpaceOptimized {

	/**
	 * Space: O(1)
	 * Time: O(n)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 2};
		System.out.println(duplicate(arr));
	}
	
	private static int duplicate(int[] arr){
		int n = arr.length - 1;
		int posInCycle = n + 1;
		
		//start at head and walk n steps
		for(int i = 0; i < n; i++)
			posInCycle = arr[posInCycle - 1];
		
		//find the length of cycle
		int visited = posInCycle;
		int current = arr[posInCycle - 1];
		int steps = 1;
		
		while(current != visited){
			current = arr[current - 1];
			steps++;
		}
		
		int head = n + 1;
		int ahead = n + 1;
		
		for(int i = 0; i < steps; i++)
			ahead = arr[ahead - 1];
		
		while(head != ahead){
			head = arr[head - 1];
			ahead = arr[ahead - 1];
		}
		
		return head;
	}
}
/**
 * update required: greedy approach to work with 2 or more digit numbers as well
 */
package edu.mandeep.coursera.AlgortihmsToolBox.week3;

import java.util.Arrays;

/**
 * What is the largest number that consists of digits 3, 9, 5, 9, 7, 1? Use all digits.
 * Posible solutions: 359179, 537991, 913579, . . .
 * Correct answer: 997531.
 * @author mandeep
 */
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {3, 20, 5, 9, 7, 1};
		
		//largestNumber(a);
		findLargestDigit(a);
	}

	private static void largestNumber(int[] arr) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i = arr.length - 1; i >=0; i--){
			System.out.print(arr[i]);
		}
	}
	
	
	private static void findLargestDigit(int[] arr){
		
	}
}
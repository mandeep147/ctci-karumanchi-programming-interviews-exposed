/**
 * 
 */
package edu.mandeep.coursera.AlgortihmsToolBox.week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  Problem 2: Last Digit of a Large Fibonacci Number
 *  Given an integer 𝑛, find the last digit of the 𝑛th Fibonacci number 𝐹𝑛 (that is, 𝐹𝑛 mod 10).
 * @author mandeep
 *
 */
public class LargestFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacciNumber(n));
	}
	
	/**
	 * Time: O(1)
	 * @param n
	 * @return
	 */
	public static int fibonacciNumber(int n){
		int arr[] = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= n; i++){
			arr[i] = (arr[i-1] + arr[i-2]) % 10;
		}		
		return arr[n];
	}
}
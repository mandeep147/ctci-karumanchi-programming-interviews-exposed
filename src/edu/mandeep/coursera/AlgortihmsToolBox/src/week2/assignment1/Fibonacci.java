/**
 * 
 */
package week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem 1: Small Fibonacci Number
 * Given an integer 𝑛, find the 𝑛th Fibonacci number 𝐹𝑛.
 * @author mandeep
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		System.out.println(fibonacci(a));
		System.out.println(fibonacciRecursive(a));
		System.out.println(fibonacciDynamic(a));
	}
	
	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O (1)
	 * @param n
	 * @return
	 */
	static int fibonacci(int n){
		int sum = 0, a = 0, b = 1;
		if(n <= 1)
			return n;
		for(int i = 2; i <= n; i++){
			sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
	
	/**
	 * Recursive Solution
	 * Time: T(n) = T(n-1) + T(n-2) ; exponential
	 * Space: O(n)
	 * @param n
	 * @return
	 */
	public static int fibonacciRecursive(int n){
		if(n <= 1)
			return n;
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	/**
	 * Using Dynamic Programming
	 * Time: O(n)
	 * Space: O(n)
	 * @param n
	 * @return
	 */
	public static int fibonacciDynamic(int n){
		int arr[] = new int[n+1];
		int i;
		arr[0] = 0;
		arr[1] = 1;
		
		for(i = 2; i <= n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
}

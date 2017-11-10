/**
 * 
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 9;
		System.out.println(fibonacci(n));
		System.out.println(fibonacciRecursion(n));
		System.out.println(fibonacciDP(n));
		System.out.println(fibonacciMatrix(n));
	}

	/**
	 * Time Complexity: O(n)
	 * Extra Space: O(1)
	 * @param n
	 * @return
	 */
	private static int fibonacci(int n) {
		int a = 0, b = 1, c;
		if(n == 0)
			return a;
		for(int i = 2; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
	/**
	 * Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	 * @param n
	 * @return
	 */
	private static int fibonacciRecursion(int n){
		if(n <= 1)
			return n;
			
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
	
	/**
	 * Time Complexity: O(n)
	 * Extra Space: O(n)
	 * @param n
	 * @return
	 */
	private static int fibonacciDP(int n){
		int[] output = new int[n + 1];
		output[0] = 0;
		output[1] = 1;
		
		for(int i = 2; i <= n; i++)
			output[i] = output[i - 1] + output[i - 2];
		return output[n];
	}
	
	/**
	 * Using power of the matrix {{1,1},{1,0}}
	 * Time Complexity: O(n)
	 * Extra Space: O(1)
	 * @param n
	 * @return
	 */
	private static int fibonacciMatrix(int n){
		int[][] matrix = {
				{1,1},
				{1,0}
				};
		if(n == 0)
			return 0;
		
		power(matrix, n - 1);
		//powerOptimized(matrix, n - 1);
		return matrix[0][0];
	}

	/**
	 * @param matrix
	 * @param n
	 */
	private static void power(int[][] matrix, int n) {
		int i;
		int m[][] = {
				{1,1},
				{1,0}
				};
		for(i = 2; i <= n; i++)
			multiply(matrix, m);
	}

	/**
	 * @param matrix
	 * @param m
	 */
	private static void multiply(int[][] matrix, int[][] m) {
		int x = matrix[0][0] * m[0][0] + matrix[0][1] * m[1][0];
		int y = matrix[0][0] * m[0][1] + matrix[0][1] * m[1][1];
		int u = matrix[1][0] * m[0][0] + matrix[1][1] * m[1][0];
		int v = matrix[1][0] * m[0][1] + matrix[1][1] * m[1][1];
		
		matrix[0][0] = x;
		matrix[0][1] = y;
		matrix[1][0] = u;
		matrix[1][1] = v;
	}
	
	/**
	 * Time Complexity: O(Logn)
	 * Extra Space: O(Logn) for function call stack
	 * @param a
	 * @param n
	 */
	private static void powerOptimized(int[][] a, int n){
		if(n == 0 || n == 1)
			return;
		
		int m[][] = {
				{1,1},
				{1,0}
				};
		
		powerOptimized(a, n/2);
		multiply(a, a);
		
		if(n % 2 != 0)
			multiply(a, m);
	}
}
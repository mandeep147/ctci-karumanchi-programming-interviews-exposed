/**
 * 
 */
package edu.mandeep.coursera.AlgortihmsToolBox.week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Problem 6: Sum of Fibonacci Numbers
 * Given an integer 𝑛, find the last digit of the sum 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.
 * @author mandeep
 *
 */
public class FibonacciSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine());
		
		System.out.println(fibonacciSum(a));

	}

	private static long fibonacciSum(long m) {
		long pisanoPeriod = 60;
		long remainder = m % pisanoPeriod;
		long  a = 0, b = 1, c = a + b;
		long sum = 0;
		for(int i = 1; i < remainder; i++){
			sum += c;
			sum %= 10;
			c = ( a + b) % 10;
			a = b;
			b = c;
		}
		return sum;
	}
}
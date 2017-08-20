/**
 * not solved!!
 */
package edu.mandeep.coursera.AlgortihmsToolBox.week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author mandeep
 *
 */
public class PartialSumFibonacci {

	/** Problem 7: Partial Sum of Fibonacci Numbers
	 * Given two non-negative integers 𝑚 and 𝑛, where 𝑚 ≤ 𝑛, find the last digit of the sum 𝐹𝑚 + 𝐹𝑚+1 +
· · · + 𝐹𝑛.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("\\s+");	
		long m = Long.parseLong(arr[0]);
		long n = Long.parseLong(arr[1]);
		
		if(m == n)
			System.out.println((fibo(m) ) ) ;
		else
			System.out.println((fiboMod(n + 2) - fiboMod(m + 1)) % 10);
	}
	
	private static long fiboMod(long m){
		long pisanoPeriod = 60;
		long remainder = m % pisanoPeriod;
		long  a = 0, b = 1, c = a+b;
		long sum = 0;
		System.out.println("m: "+m);
		for(int i = 0; i < remainder; i++){
			sum += c;
			sum %= 10;	
			System.out.println(sum+" "+c+" "+i);
			c = ( a + b) % 10;
			a = b;
			b = c;
		}
		System.out.println(sum);
		return sum % 10;
	}
	
	private static long fibo(long m){
		long pisanoPeriod = 60;
		long remainder = m % pisanoPeriod;
		long  a = 0, b = 1, c = a+b;
		System.out.println("m: "+m);
		for(int i = 0; i < remainder; i++){
			System.out.println(c+" "+i);
			c = ( a + b) % 10;
			a = b;
			b = c;
		}
		System.out.println(a);
		return a;
	}

}
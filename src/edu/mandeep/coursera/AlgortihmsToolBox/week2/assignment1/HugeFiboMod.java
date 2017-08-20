/**
 * 
 */
package edu.mandeep.coursera.AlgortihmsToolBox.week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**  Problem 5: Huge Fibonacci Number modulo m
 * Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).
 * @author mandeep
 *
 */
public class HugeFiboMod {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("\\s+");
		
		long n = Long.parseLong(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		System.out.println(fiboMod(n , m));
	}
	
	/**
	 *  For 𝑚 = 2, the period is 011 and has length 3, while for 𝑚 = 3 the period is 01120221 
	 *  and has length 8. Therefore, to compute, say, 𝐹2015 mod 3 we just need to find the 
	 *  remainder of 2015 when divided by 8. Since 2015 = 251 · 8 + 7, we conclude that 
	 *  𝐹2015 mod 3 = 𝐹7 mod 3 = 1.
	 *  for any integer 𝑚 ≥ 2, the sequence 𝐹𝑛 mod 𝑚 is periodic. 
	 *  The period always starts with 01 and is known as Pisano period.
	 */
	
	private static long getPisano(int m){
		long a = 0, b = 1;
		long c = a + b;
		long pisanoPeriod = 1;
		for(long i = 0; i <= m * m; i++){
			c = (a + b) % m;
			a = b;
			b = c;
			if(a == 0 && b == 1){
				pisanoPeriod = i + 1;
				break;
			}
		}
		return pisanoPeriod;
	}
	
	public static long fiboMod(long n, int m){
		long remainder = n % getPisano(m);
		long  a = 0, b = 1;
		long result = remainder;
		for(int i = 1; i < remainder; i++){
			result = ( a + b) % m;
			a = b;
			b = result;
		}
		return result % m;
	}
}
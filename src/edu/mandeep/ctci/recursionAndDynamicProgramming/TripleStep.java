/**
 * Problem 8.1 : Triple Step
 */
package edu.mandeep.ctci.recursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class TripleStep {

	public static void main(String[] args){
		System.out.println(countWays(9));
		System.out.println(countWaysMemoized(9));
	}
	
	/**
	 * Runtime: O(pow(3, n))
	 * @param n
	 * @return
	 */
	public static int countWays(int n){
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}
	
	/**
	 * Complexity: O(m*n)
	 * m = mth stair
	 * n = no of steps
	 * @param n
	 * @return
	 */
	public static int countWaysMemoized(int n){
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWaysMemoized(n, memo);
	}

	/**
	 * @param n
	 * @param memo
	 * @return
	 */
	private static int countWaysMemoized(int n, int[] memo) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else if(memo[n] > -1)
			return memo[n];
		else 
			memo[n] = countWaysMemoized(n - 1, memo) + countWaysMemoized(n - 2, memo) + countWaysMemoized(n - 3, memo);
		return memo[n];
	}
}
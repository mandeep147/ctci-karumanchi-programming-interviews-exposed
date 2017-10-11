/**
 * Problem 5.1: Insertion
 * 2 32-bit numbers, N and M are given and 2 bit positions i and j
 * Write method to insert M into N s.t M start s at bit j and ends at bit i
 * 
 * eg: M = 10011, N = 10000000000, i = 2, j = 6
 * Output: N = 10001001100
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class Insertion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1024;
		int m = 19;
		int i = 2;
		int j = 6;
		System.out.println(updateBits(n, m, i, j));
		
	}

	private static int updateBits(int n, int m, int i , int j){
		/**
		 * create a mask to clear bits i through j in n
		 * eg if i = 2 and j = 4 then mask should be 11100011
		 */
		
		int allOnes = ~0;
		int left = allOnes << (j + 1); //1s before position j followed by 0s; left = 11100000
		int right = ((1 << i) - 1); //1s after position i; right = 00000011
		
		int mask = left | right; // all 1s except for 0s between i and j, mask = 11100011
		
		/**
		 * clear bits j through i 
		 * then merge m with n
		 */
		
		int n_cleared = (n & mask); //clear bits j through i
		int mShifted = m << i; //move m to correct position
		return n_cleared | mShifted; //OR 
	}
}
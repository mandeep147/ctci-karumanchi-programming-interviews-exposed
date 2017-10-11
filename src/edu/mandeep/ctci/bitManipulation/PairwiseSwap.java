/**
 * Problem 5.7: Pairwise Swap
 * Write program to swap odd and even bits in an integer with as few instructions as possible
 * 
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class PairwiseSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 23;
		System.out.println(swapEvenOddBits(a));
	}

	private static int swapEvenOddBits(int a){
		return ( ((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1));
	}
}
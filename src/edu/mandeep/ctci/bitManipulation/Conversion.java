/**
 * Problem 5.6: Conversion
 * Function to determine the number of bits needed to convert integer A to integer B.
 * eg: input: 29 (11101), and 15 (01111)
 * output: 2
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class Conversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 29, b = 15;
		System.out.println(bitSwapRequired(a, b));
		System.out.println(bitrequired(a, b));
	}

	private static int bitSwapRequired(int a, int b){
		int count = 0;
		for(int i = a ^ b; i != 0; i = i >> 1)
			count += i & 1;
		return count;
	}
	
	private static int bitrequired(int a, int b){
		int count = 0;
		for(int c = a ^ b; c != 0; c = c & (c- 1))
			count++;
		return count;
	}
}
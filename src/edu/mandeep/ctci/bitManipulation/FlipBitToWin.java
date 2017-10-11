/**
 * Problem 5.3: Flip bit to Win
 * given an integer, you can flip exactly one bit from 0 to 1. 
 * Write code to find the lenght of longest sequence of 1s that can be created.
 * 
 * eg: input: 1775 ==> 11011101111
 * output: 8
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class FlipBitToWin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 13;
		System.out.println("======================");
		System.out.println(num);
		System.out.println(maxBitLength(num));
		
		num = 1775;
		System.out.println("======================");
		System.out.println(num);
		System.out.println(maxBitLength(num));
		
		num = 15;
		System.out.println("======================");
		System.out.println(num);
		System.out.println(maxBitLength(num));
	}

	/**
	 * Complexity: O(b)
	 * Space: O(1)
	 * @param num
	 * @return
	 */
	private static int maxBitLength(int num){
		if(~num == 0)
			return 8 * Integer.SIZE;
		int currentLength = 0, prevLength = 0, maxLength = 0;
		
		while(num != 0){
			//if current bit is 1, increment current length of sequence
			if( (num & 1) == 1)
				currentLength++;
			
			//if current bit is 0, check the next bit
			else if( (num & 1) == 0){
				prevLength = ( num & 2) == 0? 0 : currentLength;
				
				currentLength = 0;
			}
			
			maxLength = Math.max(prevLength + currentLength, maxLength);
			num >>>= 1;
		}
		return maxLength + 1;
	}
}
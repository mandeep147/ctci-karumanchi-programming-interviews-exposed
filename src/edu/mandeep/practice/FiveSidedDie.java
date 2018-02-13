/**
 * You have a function rand7() that generates a random integer from 1 to 7. 
 * Use it to write a function rand5() that generates a random integer from 1 to 5.
 * 
 * rand7() returns each integer with equal probability. 
 * rand5() must also return each integer with equal probability.
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class FiveSidedDie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(rand5());
		System.out.println(rand5());
		System.out.println(rand5());
		System.out.println(rand5());
	}

	/**
	 * "re-roll" whenever we get a number greater than 5. So each integer 1,2,3,4, or 5 has a probability 1/7​​
	 *  of appearing at each roll.
	 *  
	 *  Complexity: O(∞) time (we might keep re-rolling forever) and O(1) space
	 * @return
	 */
	private static int rand5() {
		int result = 7;
		
		while(result > 5){
			result = rand7();
		}
		return result;
	}

	/**
	 * @return
	 */
	private static int rand7() {
		return (int)(1 + Math.random() * 7);
	}

}
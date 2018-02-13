/**
 * You have a function rand5() that generates a random integer from 1 to 5. 
 * Use it to write a function rand7() that generates a random integer from 1 to 7.
 * 
 * rand5() returns each integer with equal probability. 
 * rand7() must also return each integer with equal probability.
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class SevenSidedDie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(rand7());
		System.out.println(rand7());
		System.out.println(rand7());
		System.out.println(rand7());
		System.out.println(rand7());
		System.out.println(rand7());
	}

	/**
	 * Complexity: O(∞) time (we might keep re-rolling forever) and O(1) space
	 * @return
	 */
	private static int rand7() {
		while(true){
			int roll1 = rand5();
			int roll2 = rand5();
			
			int outcome = ( roll1 - 1) * 5 + (roll2 - 1) + 1;
			
			if(outcome > 21)
				continue;
			return (outcome % 7) + 1;
		}
	}

	/**
	 * @return
	 */
	private static int rand5() {
		return (int)(1 + Math.random() * 5);
	}

}
/**
 * 
 */
package edu.mandeep.ctci.bitManipulation;

/**
 * @author mandeep
 *
 */
public class ArithematicAndLogicalShift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		repeatedArithematic(001100, 10);
		repeatedLogical(001100, 10);
	}
	
	private static void repeatedArithematic(int x, int count){
		System.out.println("Arithematic Shift");
		for(int i = 0; i < count; i++) {
			System.out.println(x >>= 1);
		}
	}
	
	private static void repeatedLogical(int x, int count){
		System.out.println("Logical Shift");
		for(int i = 0; i < count; i++) {
			System.out.println(x >>>= 1);
		}
	}
}
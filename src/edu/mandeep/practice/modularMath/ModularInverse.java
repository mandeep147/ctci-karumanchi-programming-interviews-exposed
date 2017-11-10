/**
 * Given two integers ‘a’ and ‘m’, 
 * find modular multiplicative inverse of ‘a’ under modulo ‘m’.
 */
package edu.mandeep.practice.modularMath;

/**
 * @author mandeep
 *
 */
public class ModularInverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 3, m = 11;
		System.out.println("Inverse of "+ a+ " under modulo "+m+" is "+inverse(a, m));
	}

	/**
	 * Approach: Extended Euclidean Algo
	 * i.e when m and a are coprime
	 * Complexity: O(logm)
	 * @param a
	 * @param m
	 * @return
	 */
	private static int inverse(int a, int m) {
		int[] val = gcd(a, m);
		
		int d = val[0];
		int aa = val[1];
		int b = val[2];
		
		if( d > 1){
			System.out.println("no inverse exists for "+a);
			return 0;
		}
		if(aa > 0)
			return aa;

		return m + aa;
	}

	/**
	 * @param a
	 * @param m
	 * @param x
	 * @param y
	 * @return
	 */
	private static int[] gcd(int p, int q) {
		if(q == 0)
			return new int[]{p, 1, 0};
		
		int[] val = gcd(q, p % q);
		int d = val[0];
		int a = val[2];
		int b = val[1] - (p/ q) * val[2];
		return new int[]{d, a, b};
	}

}
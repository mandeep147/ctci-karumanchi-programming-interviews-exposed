/**
 * Calculate GCD using Euclidean Algorithm
 */
package edu.mandeep.practice.modularMath;

/**
 * @author mandeep
 *
 */
public class EuclideanGCDAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 270, b = 192;
		System.out.println("GCD of "+a+" and "+b+" is: "+gcdEuclidean(a,b));
		System.out.println("GCD of "+16+" and "+4+" is: "+gcdEuclidean(16,4));
		System.out.println("GCD of "+1052+" and "+52+" is: "+gcdEuclidean(1052,52));

		System.out.println("non-recursive solution");
		System.out.println("GCD of "+a+" and "+b+" is: "+gcd(a,b));

	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd(int a, int b) {
		while( b != 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcdEuclidean(int a, int b) {
		if(b == 0)
			return a;
		
		if(a == 0)
			return b;
		
		return gcdEuclidean(b, a % b);
	}

}
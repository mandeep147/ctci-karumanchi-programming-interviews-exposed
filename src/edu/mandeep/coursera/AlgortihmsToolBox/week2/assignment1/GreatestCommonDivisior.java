package edu.mandeep.coursera.AlgortihmsToolBox.week2.assignment1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Problem 3: Greatest Common Divisor
 * Given two integers 𝑎 and 𝑏, find their greatest common divisor
 * @author mandeep
 *
 */
public class GreatestCommonDivisior {

	/** 
	 * @param args
	 * @throws Exception 
	 * Complexity: O(log(ab))
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/*	int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		*/
		
		String str = br.readLine();
		String[] arr = str.split("\\s+");
		
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		System.out.println("GCD is: "+gcd(a,b));
	}
	
	public static int gcd (int a, int b){
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
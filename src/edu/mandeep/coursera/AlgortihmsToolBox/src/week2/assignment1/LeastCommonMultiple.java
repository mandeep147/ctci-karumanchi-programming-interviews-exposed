/**
 * 
 */
package week2.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Problem 4: Least Common Multiple
 * Given two integers 𝑎 and 𝑏, find their least common multiple.
 * @author mandeep
 *
 */
public class LeastCommonMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		LeastCommonMultiple least = new LeastCommonMultiple();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			String[] arr = str.split("\\s+");
			
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			System.out.println(least.lcm(a,b));
	}

	public int lcm(int a, int b){
		return (a * b) / gcd(a,b);
	}
	
	private int gcd (int a, int b){
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
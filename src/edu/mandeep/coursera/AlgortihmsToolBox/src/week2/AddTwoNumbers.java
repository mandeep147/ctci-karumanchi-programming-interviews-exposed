package week2;
import java.util.Scanner;

/**
 * @author mandeep
 *Problem. Given two digits a and b, find a+b.

Input format. The first line of the input contains two integers a and b (separated by a space).

Constraints. 0≤a,b≤9.

Output format. Output a+b.
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	    int a = s.nextInt();
	    int b = s.nextInt();
	    System.out.println(a + b);
	}
}
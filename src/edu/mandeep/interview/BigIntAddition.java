/**
 * 
 */
package edu.mandeep.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Implement a Big Integer class with an addition operation
 * Displaying the number in base 10 is a requirement
 * @author mandeep
 */
public class BigIntAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());*/
		//bigIntAdd(a, b);
		bigIntAdd(10, 2);
		String first = "23";
		String second = "10";
		System.out.println(sumStrings(first, second));
	}
	
	private static void bigIntAdd(int a, int b){
		BigInteger first = BigInteger.valueOf(a);
		BigInteger second = BigInteger.valueOf(b);
		
		BigInteger sum = first.add(second);
		System.out.println(first +" "+second);
		System.out.println(sum);
		System.out.println(first.add(second));
	}
	

	public static String sumStrings(String a, String b){
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();

        int i = num1.length - 1;
        int j = num2.length - 1;

        StringBuilder sumString = new StringBuilder();
        int carry = 0;

        while(i >= 0 || j >= 0){
            int d1 = 0;
            int d2 = 0;

            if (i >= 0) {
            	d1 = num1[i--] - '0';
            	System.out.println("d1: "+d1);
            }
            if (j >= 0) {
            	d2 = num2[j--] - '0';
            	System.out.println("d2: "+d2);
            }

            int sum = d1 + d2 + carry;
            if (sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else carry = 0;

            sumString.insert(0, sum);
        }

        return sumString.toString();
    }
}
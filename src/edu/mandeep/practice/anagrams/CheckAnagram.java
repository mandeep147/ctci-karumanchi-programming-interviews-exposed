/*
 * check if two strings consist of same characters
*/
package edu.mandeep.practice.anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class CheckAnagram {
	static boolean isAnagram(String a, String b) {

		char first[] = a.toLowerCase().toCharArray();
		char second[] = b.toLowerCase().toCharArray();

		Arrays.sort(first);
		Arrays.sort(second);

		return Arrays.equals(first, second);

	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}	
}

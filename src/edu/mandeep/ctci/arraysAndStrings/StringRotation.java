/**
 * Problem 1.9: String Rotation
 * Given isSubstring() which checks if one word is a substring of another.
 * Given 2 strings, s1, s2 check if s2 is a rotation of s1 using only one call to isSubstring()
 * ex: s1= waterbottle
 * s2 = erbottlewat
 * Output: true s2 is rotation on s1
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(isRotation(s1, s2));
	}
	
	/**
	 * Complexity: O(N) 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isRotation(String s1, String s2){
		int length = s1.length();
		if(length == s2.length() && length > 0){
			String newS1 = s1 + s1;
			return isSubstring(newS1, s2);
		}
		return false;
	}

	/**
	 * @param newS1
	 * @param s2
	 * @return
	 */
	private static boolean isSubstring(String newS1, String s2) {
		return newS1.contains(s2);
	}
}
/**
 * Problem 1.5: One Away
 * Given two strings, check if they aee one(or zero) edit (insert, remove or replace a character) away.
 * Ex: pale, ple : true
 * pale, bale: true
 * pale, bae: false
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * Complexity: O(n); n = length of shorter string
 * @author mandeep
 */
public class OneAway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "bae";
		System.out.println(isOneAway(s1, s2));
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isOneAway(String s1, String s2) {
		if(s1.length() == s2.length())
			return isOneReplace(s1, s2);
		else if(s1.length() + 1 == s2.length())
			return isOneEdit(s1, s2);
		else if(s1.length() - 1 == s2.length())
			return isOneEdit(s2, s1);
		return false;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isOneReplace(String s1, String s2) {
		boolean isDiffer = false;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(isDiffer){
					return false;
				}
				isDiffer = true;
			}
		}
		return true;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isOneEdit(String s1, String s2) {
		int index1 = 0, index2 = 0;
		while(index2 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;;
			}
		}
		return true;
	}
}
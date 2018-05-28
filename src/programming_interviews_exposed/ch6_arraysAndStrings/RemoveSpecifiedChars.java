/**
 * 
 */
package programming_interviews_exposed.ch6_arraysAndStrings;

import java.util.HashSet;

/**
 * @author mandeep
 *
 */
public class RemoveSpecifiedChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Battle of the Vowels: Hawaii vs. Germany";
		String r = "aeiou";
		System.out.println("after remoing: "+ removeSpecifiedChars(s, r));

	}

	/**
	 * @param s
	 * @param r
	 * @return
	 */
	private static String removeSpecifiedChars(String s, String r) {
		HashSet<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r.length(); i++)
			set.add(r.charAt(i));
		for(int i = 0; i < s.length(); i++){
			if(!set.contains(s.charAt(i)))
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}

/**
 * 
 */
package programming_interviews_exposed.ch6_arraysAndStrings;

import java.util.HashMap;

/**
 * @author mandeep
 *
 */
public class FirstNonRepeatedChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "total";
		System.out.println("first non repeated char is: " + nonRepeatedChar(s));
	}

	/**
	 * @param s
	 * @return
	 */
	private static Character nonRepeatedChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else
				map.put(s.charAt(i), 1);
		}
		
		for(int i = 0; i < s.length(); i++){
			if(map.get(s.charAt(i)) == 1)
				return s.charAt(i);
		}
		
		return null;
	}

}

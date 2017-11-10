/**
 * 
 */
package edu.mandeep.practice.stringmatching;

/**
 * @author mandeep
 *
 */
public class NaiveSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "acaabcaab";
		String pattern = "aab";
		naiveStringMatcher(text, pattern);
	}

	/**
	 * @param text
	 * @param pattern
	 */
	private static void naiveStringMatcher(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int limit = n - m;
		int j = 0;
		
		for(int i = 0; i <= limit ; i++){
			j = 0;
			for(j = 0; j < m; j++)
				if(text.charAt(i + j) != pattern.charAt(j))
					break;
			
			if(j == m)
				System.out.println("pattern found at index: "+i);
		}
	}

}

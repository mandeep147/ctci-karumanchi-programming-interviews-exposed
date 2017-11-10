/**
 * 
 */
package edu.mandeep.practice.stringmatching;

/**
 * @author mandeep
 *
 */
public class KnuthMorrisPratt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "arcarcarcarc";
		String pattern = "car";
		kmp(text, pattern);
	}

	/**
	 * @param text
	 * @param pattern
	 */
	private static void kmp(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int[] pi = computePrefixFunction(pattern);
		
		int q = 0;
		int i;
		for(i = 0; i < n; i++){
			while(q > 0 && pattern.charAt(q) != text.charAt(i))
				q = pi[q-1];
			if(pattern.charAt(q) == text.charAt(i))
				q = q + 1;
			if(q == m){
				System.out.println("pattern found at index: "+ (i - m + 1));
				q = pi[q];
			}
		}
	}

	/**
	 * @param pattern
	 * @return
	 */
	private static int[] computePrefixFunction(String pattern) {
		int m = pattern.length();
		int[] pi = new int[m+1];
		
		pi[0] = 0;
		int k = 0;
		int q;
		
		for(q = 1; q < m; q++){
			while(k > 0 && pattern.charAt(k + 1) != pattern.charAt(q))
				k = pi[k];
			if(pattern.charAt(k + 1) == pattern.charAt(q))
				k = k + 1;
			pi[q] = k;
		}
		
		return pi;
	}
}

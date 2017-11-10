/**
 * 
 */
package edu.mandeep.practice.stringmatching;

/**
 * @author mandeep
 *
 */
public class FiniteAutomata {
	public final static int d = 256;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		search(text, pattern);
	}

	/**
	 * @param text
	 * @param pattern
	 */
	private static void search(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		int[][] tf = new int[m + 1][d];
		computeTransitionFunction(pattern, m, tf);
		
		int i, state = 0;
		
		for(i = 0;  i < n; i++){
			state = tf[state][text.charAt(i)];
			if(state == m)
				System.out.println("pattern found at index: "+ (i - m + 1));
		}
	}

	/**
	 * @param pattern
	 * @param m
	 * @param tf
	 */
	private static void computeTransitionFunction(String pattern, int m, int[][] tf) {
		int state, x;
		
		for(state = 0; state <= m; state++){
			for( x = 0; x < d; x++){
				tf[state][x] = getNextState(pattern, m, state, x);
			}
		}
	}

	/**
	 * @param pattern
	 * @param m
	 * @param state
	 * @param x
	 * @return
	 */
	private static int getNextState(String pattern, int m, int state, int x) {
		if(state < m && x == pattern.charAt(state))
			return state + 1;
		
		int ns, i;
		
		for(ns = state; ns > 0; ns--){
			if(pattern.charAt(ns - 1) == x){
				for(i = 0; i < ns - 1; i++){
					if(pattern.charAt(i) != pattern.charAt(state - ns + 1 +i))
						break;
				}
				
				if(i == ns - 1)
					return ns;
			}
		}
		
		return 0;
	}

}

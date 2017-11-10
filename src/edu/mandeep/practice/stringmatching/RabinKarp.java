/**
 * 
 */
package edu.mandeep.practice.stringmatching;

/**
 * @author mandeep
 *
 */
public class RabinKarp {

	public final static int d = 256;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "GEEKS FOR GEEKS";
		String pattern = "GEEK";
		int q = 101;
		rabinKarp(text, pattern, q);
	}

	/**
	 * @param text
	 * @param pattern
	 */
	private static void rabinKarp(String text, String pattern, int q) {
		int n = text.length();
		int m = pattern.length();
		int h = 1;
		int p = 0, t = 0;
		int j;
		
		h = (int)( Math.pow(d, m - 1) % q );
		
		for(int i = 0; i < m; i++){
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		
		for(int i = 0; i <= n - m; i++){
			if(p == t){
				for(j = 0; j < m; j++){
					if(text.charAt(i+ j) != pattern.charAt(j))
						break;
				}
				
				if(j == m)
					System.out.println("pattern found at index: "+i);
			}
			
			if(i < n-m){
				t = ( d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
				
				if(t < 0)
					t = (t + q);
			}
		}
	}

}

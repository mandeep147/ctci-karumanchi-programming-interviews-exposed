/**
 * 
 */
package programming_interviews_exposed.ch6_arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Do or do not, there is no try.";
		System.out.println("after reverse: "+reverseWords(s));
	}

	/**
	 * @param s
	 * @return
	 */
	private static String reverseWords(String s) {
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i >= 0; i--){
			sb.append(arr[i]+" ");
		}
		return sb.toString().trim();
	}

}

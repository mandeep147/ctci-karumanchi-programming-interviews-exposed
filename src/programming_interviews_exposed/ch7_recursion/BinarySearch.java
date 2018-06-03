/**
 * 
 */
package programming_interviews_exposed.ch7_recursion;

/**
 * @author mandeep
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 10};
		int n = 7;
		int index = binarySearch(arr, n);
		System.out.println(index);
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int binarySearch(int[] arr, int n) {
		return binarySearch(arr, n, 0, arr.length-1);
	}

	/**
	 * @param arr
	 * @param n
	 * @param i
	 * @param j
	 * @return
	 */
	private static int binarySearch(int[] arr, int n, int start, int end) {
		if(arr.length == 0 || arr == null)
			return -1;
		int mid = (start + end)/2;
		if(n == arr[mid])
			return mid;
		else if(n < arr[mid])
			return binarySearch(arr, n, start, mid -1);
		else 
			return binarySearch(arr, n, mid+1, end);
	}

}

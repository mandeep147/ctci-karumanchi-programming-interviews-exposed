/**
 * Given a sorted array of strings interspersed with empty strings
 * Write a method to find the location of a given string
 * 
 * eg: {"at", "", "", "ball", "", "", "car", "", "", "dead", "",""}
 * input: ball
 * output: 4
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class SparseSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dead", "",""};
		String search = "ball";
		System.out.println(searchString(arr, search) );
	}

	/**
	 * Complexity: O(n)
	 * @param arr
	 * @param search
	 * @return
	 */
	private static int searchString(String[] arr, String search) {
		if(arr == null || search == null || search == "")
			return -1;
		return searchString(arr, search, 0, arr.length);
	}

	/**
	 * @param arr
	 * @param search
	 * @param i
	 * @param j
	 * @return
	 */
	private static int searchString(String[] arr, String search, int low, int high) {
		if(low > high)
			return -1;
		int mid = (low + high) /2 ;
		
		if(arr[mid].isEmpty()){
			int left = mid - 1;
			int right = mid + 1;
			
			while(true){
				if(left < low && right > high)
					return -1;
				else if(left >= low && !arr[left].isEmpty()){
					mid = left;
					break;
				}else if(right <= high && !arr[mid].isEmpty()){
					mid = right;
					break;
				}
				right++;
				left--;
			}
		}
		
		if(search.equals(arr[mid]))
			return mid;
		else if(arr[mid].compareTo(search) < 0)
			return searchString(arr, search, mid + 1, high); //search right array
		else 
			return searchString(arr, search, low, mid - 1); //search left array
	}

}
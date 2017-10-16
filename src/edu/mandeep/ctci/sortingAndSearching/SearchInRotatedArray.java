/**
 * Problem 10.3: Search in Rotated Array
 * Given a sorted array of n integers that has been rotated an unknown number of times
 * Find an element in the array.
 * eg: 
 * input: find 5 in
 *  {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 *  output: 8 (index of is 8)
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class SearchInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int search = 1;
		System.out.println(searchRotatedArray(arr, 0 , arr.length - 1, search));
	}

	/**
	 * Complexity:
	 * if all elements are unique: O(log n)
	 * else O(n)
	 * @param arr
	 * @param search 
	 * @param right 
	 * @param left 
	 * @return
	 */
	private static int searchRotatedArray(int[] arr, int left, int right, int search) {
		int mid = (left + right) / 2;
		
		if(search == arr[mid])
			return mid;
		
		if(left > right)
			return -1;
		
		if(arr[left] < arr[mid]){
			if(search >= arr[left] && search < arr[mid])
				return searchRotatedArray(arr, left, mid - 1, search); //search left array
			else 
				return searchRotatedArray(arr, mid + 1, right, search); //search right array
		}else if(arr[mid] < arr[left]){
			if(search > arr[mid] && search <= arr[right])
				return searchRotatedArray(arr, mid + 1, right, search); //search right array
			else
				return searchRotatedArray(arr, left, mid - 1, search); //search left array
		}else if(arr[left] == arr[mid]){	//left or right half is all repeats
			if(arr[mid] != arr[right])	//if right is different, search right array
				return searchRotatedArray(arr, mid + 1, right, search); //search right array
			else{
				int result = searchRotatedArray(arr, left, mid - 1, search); //search left array
				if(result == 1)
					return searchRotatedArray(arr, mid + 1, right, search); //search right array
				else 
					return result;
			}
		}
		
		return -1;
	}

}
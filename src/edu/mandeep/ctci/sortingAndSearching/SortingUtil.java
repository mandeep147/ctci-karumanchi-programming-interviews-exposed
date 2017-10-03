/**
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class SortingUtil {
	public static int[] defineArr(){
		int[] arr = {6, 5, 2, 1, 9, 8, 4};
		
		printArray(arr);
		
		System.out.println();
		System.out.println("Array after sorting: ");
		
		return arr;
	}

	/**
	 * @param arr
	 */
	static void printArray(int[] arr) {
		for(int item: arr)
			System.out.print(item+" ");
	}
}

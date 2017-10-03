/**
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * Time: O(nlogn)
 * Worst: O(n^2)
 * Space: O(logn)
 * @author mandeep
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = SortingUtil.defineArr();
		quickSort(array);
		
		SortingUtil.printArray(array);
	}

	/**
	 * @param array
	 */
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		
		if(left < index - 1)
			quickSort(arr, left, index - 1);
		
		if(index < right)
			quickSort(arr, index, right);
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		
		while(left <= right){
			while(arr[left] < pivot)
				left++;
			
			while(arr[right] > pivot)
				right--;
			
			//swap elements
			if(left <= right){
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		return left;
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}

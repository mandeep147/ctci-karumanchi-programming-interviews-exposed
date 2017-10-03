/**
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * Complexity: O(nlogn)
 * Space: O(n)
 * 
 * @author mandeep
 */
public class MergeSort {

	private static int[] arr;
	private static int[] helper;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = SortingUtil.defineArr();
		mergesort(array);
		
		SortingUtil.printArray(array);
	}

	/**
	 * 
	 * @param arr
	 */
	static void mergesort(int[] array){
		arr = array;
		helper = new int[array.length];
		mergesort(0, array.length - 1);
		
	}

	/**
	 * @param arr
	 * @param helper
	 * @param i
	 * @param j
	 */
	private static void mergesort(int low, int high) {
		if(low < high){
			int mid = low + (high - low) / 2;
			mergesort(low, mid);
			mergesort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	/**
	 * @param arr
	 * @param helper
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int low, int mid, int high) {
		for(int i = low; i <= high; i++)
			helper[i] = arr[i];
		
		int left = low;
		int right = mid + 1;
		int current = low;
		
		while(left <= mid && right <= high){
			if(helper[left] <= helper[right]){
				arr[current] = helper[left];
				left++;
			}else{
				arr[current] = helper[right];
				right++;
			}
			current++;
		}
		
		while(left <= mid){
			arr[current] = helper[left];
			current++;
			left++;
		}
	}
}
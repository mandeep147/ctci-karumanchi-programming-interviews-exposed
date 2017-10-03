/**
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
		SortingUtil.printArray(array);
		radixSort(array);
		System.out.println();
		SortingUtil.printArray(array);
	}

	/**
	 * @param array
	 */
	private static void radixSort(int[] arr) {
		int max = getMax(arr);
		
		for(int exp = 1; max/exp > 0; exp *= 10)
			countSort(arr, exp);
	}

	/**
	 * @param arr
	 * @param exp
	 */
	private static void countSort(int[] arr, int exp) {
		int result[] = new int[arr.length];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for(i = 0; i < arr.length; i++)
			count[(arr[i] /exp) % 10]++;
		
		for(i = 1; i < 10; i++)
			count[i] += count[i - 1];
		
		for(i = arr.length - 1; i >= 0; i--){
			result[count[(arr[i]/ exp) % 10] - 1] = arr[i];
			count[(arr[i]/ exp) % 10]--;
		}
		
		for(i = 0; i < arr.length; i++)
			arr[i] = result[i];
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getMax(int[] arr) {
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}

}
/**
 * Problem 10.11: Peaks and Valleys
 * In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers and
 * a "valley" is an element which is less then or equal to the adjacent integers. For example in the array,
 * {5, 8, 6, 2, 3, 4, 6}, {8, 6} are the peaks and 
 * {5, 2} are the valleys. 
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 * 
 * Example : 
 * Input : {5, 3, 1, 2, 3}
 * Output : {5, 1, 3, 2, 3}
 */
package edu.mandeep.ctci.sortingAndSearching;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class PeaksAndValleys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5, 3, 1, 2, 3};//{48, 40, 31, 62, 28, 21, 64, 40, 23, 17}; 

		for(int i : arr)
			System.out.print(i+" ");
		
		System.out.println("\nafter sorting");
		sortValleyPeak(arr);
		System.out.println(confirmValleyPeak(arr));
		
		System.out.println("\n---------------\noptimized solution");
		System.out.println("\nafter sorting");
		int[] parr = {5, 3, 1, 2, 3};
		sortValleyPeakOptimized(parr);
		for(int i : parr)
			System.out.print(i+" ");
		System.out.println(confirmValleyPeak(parr));
	}

	/**
	 * Ccomplexity: O(nlogn)
	 * @param arr
	 */
	public static void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
		
		for(int element : array)
			System.out.print(element+" ");
	}

	/**
	 * @param arr
	 * @param i
	 * @param i2
	 */
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	//=================Optimized Solution===========================
	/**
	 * Complexity: O(n)
	 * @param arr
	 */
	private static void sortValleyPeakOptimized(int[] arr) {
		for(int i = 1; i < arr.length; i += 2){
			int biggestIndex = maxIndex(arr, i - 1, i, i + 1);
			if(i != biggestIndex)
				swap(arr, i, biggestIndex);
		}
	}

	/**
	 * @param arr
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int maxIndex(int[] arr, int a, int b, int c) {
		int len = arr.length;
		int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
		int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;
		
		int max = Math.max(aValue, Math.max(bValue, cValue));
		if(aValue == max)
			return a;
		else if (bValue == max)
			return b;
		else
			return c;
	}
	
	public static boolean confirmValleyPeak(int[] array) {
		for (int i = 1; i < array.length - 1; i++) {
			int prev = array[i - 1];
			int curr = array[i];
			int next = array[i + 1];
			if (prev <= curr && curr >= next) {
				continue;
			} else if (prev >= curr && curr <= next) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
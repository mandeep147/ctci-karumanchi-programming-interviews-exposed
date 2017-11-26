/**
 * Problem 10.4: Sorted search, no size
 * given an array like d.s. Listy which lacks a size method. It have an elementAt(i) method that returns element at index i in O(1) time
 * returns -1 if i is out of bounds.
 * 
 * Given Listy containing positive sorted numbers, find the index at which an element x occurs (return any index if duplicate)
 * 
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class SortedSearchNoSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
		Listy list = new Listy(array);
		System.out.println("13 : "+search(list, 13));
		System.out.println("15 : "+search(list, 15));
	}
	
	private static int search(Listy list, int value){
		int index = 1;
		while(list.elementAt(index) != -1 && list.elementAt(index) < value)
			index *= 2;
		
		return binarySearch(list, value, index / 2, index);
	}

	/**
	 * Complexity: O(log n)
	 * @param list
	 * @param value
	 * @param i
	 * @param index
	 * @return
	 */
	private static int binarySearch(Listy list, int value, int low, int high) {
		int mid; 
		
		while(low <= high){
			mid = (low + high)/2;
			int middle = list.elementAt(mid);
			if(middle > value || middle == -1)
				high = mid - 1;
			else if(middle < value)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}

class Listy {
	int[] array;
	
	public Listy(int[] arr) {
		array = arr.clone();
	}
	
	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}
}
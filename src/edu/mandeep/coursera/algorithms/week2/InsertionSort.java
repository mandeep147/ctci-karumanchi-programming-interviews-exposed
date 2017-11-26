/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

/**
 * @author mandeep
 *
 */
public class InsertionSort {

	/**
	 * Insertion Sort
	 * N,2 compares
	 * N,2 exchanges
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		Comparable[] arr = {"do", "all", "three", "apple", "bat"};
		sort.sort(arr);
		
		for(int i = 0; i < arr.length; i ++)
			System.out.print(arr[i]+ " ");
		
		System.out.println(sort.isSorted(arr));
	}
	
	@SuppressWarnings("rawtypes")
	private void sort(Comparable[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++){
			for(int j = i; j > 0; j--){
				if(less(arr[j], arr[j-1]))
					exch(arr, j , j-1);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void exch(Comparable[] a, int i, int min) {
		Comparable swap = a[i];
		a[i] = a[min];
		a[min] = swap;
	}

	@SuppressWarnings("rawtypes")
	private boolean isSorted(Comparable[] a){
		for(int i = 0;  i < a.length; i++)
			if(less(a[i], a[i+1]))
				return true;
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}

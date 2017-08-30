/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

/**
 * @author mandeep
 *
 */
public class SelectionSort {

	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		//Comparable[] arr = {1, 4, 9, 10, 3, 5, 2, 6};
		Comparable[] arr = {"do", "all", "three", "apple", "bat"};
		sort.sort(arr);
		
		for(int i = 0; i < arr.length; i ++)
			System.out.print(arr[i]+ " ");
		
		System.out.println(sort.isSorted(arr));
	}
	
	@SuppressWarnings("rawtypes")
	private void sort(Comparable[] a){
		int n = a.length;
		for(int i = 0; i < n; i++){
			int min = i;
			for(int j = i +1; j < n; j ++)
				if(less(a[j], a[min]))
					min = j;
			exch(a, i , min);
		}
	}

	@SuppressWarnings("rawtypes")
	private void exch(Comparable[] a, int i, int min) {
		Comparable swap = a[i];
		a[i] = a[min];
		a[min] = swap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	@SuppressWarnings("rawtypes")
	private boolean isSorted(Comparable[] a){
		for(int i = 0;  i < a.length; i++)
			if(less(a[i], a[i+1]))
				return true;
		return false;
	}
}
/**
 * 
 */
package edu.mandeep.coursera.algorithms.week2;

/**
 * @author mandeep
 *
 */
public class ShellSort {

	/**shell sort --> h- sorted array
	 * increment sequence: pow(2,n)-1
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ShellSort sort = new ShellSort();
		Comparable[] arr = {"do", "all", "three", "apple", "bat"};
		sort.sort(arr);
		
		for(int i = 0; i < arr.length; i ++)
			System.out.print(arr[i]+ " ");
		
		System.out.println(sort.isSorted(arr));
	}
	
	private void sort(Comparable[] arr) {
		int n = arr.length;	
		int h = 1; 
		while(h < n/3)
			h = 3 *h + 1;
		while(h >= 1){
			for(int i = h; i < n; i++){
				for(int j = i; j >= h && less(arr[j], arr[j-h]); j -= h)
					exch(arr, j , j-h);
			}
			h = h/3;
		}
	}

	private void exch(Comparable[] a, int i, int min) {
		Comparable swap = a[i];
		a[i] = a[min];
		a[min] = swap;
	}

	private boolean isSorted(Comparable[] a){
		for(int i = 0;  i < a.length; i++)
			if(less(a[i], a[i+1]))
				return true;
		return false;
	}
	
	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}

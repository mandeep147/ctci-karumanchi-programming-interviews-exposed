/**
 * 
 */
package programming_interviews_exposed.ch8_sorting;

/**
 * @author mandeep
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,3,2,4,2};
		selectionSort(arr);
//		for(int i : arr)
//			System.out.println(i);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static void selectionSort(int[] arr) {
		//int min;
		for(int i = 0; i < arr.length-1; i++){
			int min = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			swap(arr, i, min);
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	/**
	 * @param arr
	 * @param i
	 * @param min
	 */
	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}

}
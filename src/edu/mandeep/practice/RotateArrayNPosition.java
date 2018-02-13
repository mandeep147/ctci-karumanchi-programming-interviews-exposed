package edu.mandeep.practice;

public class RotateArrayNPosition {
	public static void main(String[] args){
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		
		rotate(arr, 3);
		//arr = 7, 8, 1, 2, 3, 4, 5, 6
		System.out.println(arr[4]);
	}

	private static void rotate(int[] arr, int k) {
		
		for( int i = 0; i < k; i++){
			for(int j = arr.length - 1; j > 0; j--){
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		
	}
}

package edu.mandeep.practice.rotateArray;

public class RotateArray {
	
	public static void rotate(int[] arr, int order){
		if( arr == null || order < 0)
			throw new IllegalArgumentException("array must not be empty and order must be gretaer than 0");
		int offset = arr.length - order % arr.length ;
		
		if( offset > 0){
			int[] duplicate = arr.clone();
			
			for( int i = 0; i < arr.length; i++){
				int j = (i + offset) % arr.length;
				arr[i] = duplicate[j];
			}
		}
	}
	
	public static void main(String[] args){
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		
		rotate(arr, 3);
		//arr = 7, 8, 1, 2, 3, 4, 5, 6
		System.out.println(arr[4]);
	}
}
package edu.mandeep.practice;

public class CopyArray {

	public static void main(String[] args){
		int arr[] = {10, 20, 30, 40, 50};

		copy(arr, 2, arr.length);
	}

	private static void copy(int[] arr, int source, int destination) {

		int[] copyArr = new int[destination - source + 1];
		int j = 0;
		for(int i = source; i < destination; i++){
			copyArr[j++] = arr[i];
		}

		for(int i = 0; i < copyArr.length; i++ )
		{
			if(copyArr[i] != 0)
				System.out.print(copyArr[i]+ " ");
			else
				break;
		}



	}
}

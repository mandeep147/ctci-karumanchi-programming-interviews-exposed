package edu.mandeep.karumanchi;

public class MergeSort {

	public static void mergesort(int[] a, int left, int right){
		int mid;
		if(right > left){
			mid = (right + left)/2;
			mergesort(a, left, mid);
			mergesort(a, (mid + 1), right);
			merge(a, left, ( mid + 1 ), right);
		}
	}

	private static void merge(int[] a, int left, int mid, int right) {
		
		int i, left_end, size, pos;
		int[] temp = new int[20];
		left_end = mid - 1;
		pos = left;
		size = ( right - left + 1 );
		
		while( (left <= left_end) && (mid <= right)){
			if(a[left] <= a[mid])
				temp[pos++] = a[left++];	
			else
				temp[pos++] = a[mid++];
		}
		
		while(left <= left_end)
			temp[pos++] = a[left++];
		
		while( mid <= right)
			temp[pos++] = a[mid++];
		
		for( i = 0; i < size; i++){
			a[right] = temp[right];
			right--;
		}
		
	}
	
	public static void main(String[] args){
		int[] arr = { 12, 5, 8, 6, 9, 1};
		
		mergesort(arr, 0, ( arr.length - 1 ));
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+ " ");
	}
}
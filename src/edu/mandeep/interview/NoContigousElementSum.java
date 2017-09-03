/**
 * 
 */
package edu.mandeep.interview;

/**
 * find max sum of elements in an array such that 2 contigous elements are not 
 * allowed to skip
 * input: 10,20,30,-10,-50,40,-50,-1,-3
 * output: 10 + 20 + 30 - 10 + 40 - 1 = 89
 * @author mandeep
 */
public class NoContigousElementSum {

	/**Time Complexity: O(n)
	 * Space Complexity: O()
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {10,20,30,-10,-50,40,-50,-1,-3};
		//int[] arr = {-1,-2,-3,-4,-5 };
		maxSum(arr);
	}
	
	public static void maxSum(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length - 2; ){
			if(arr[i] > 0){
				sum += arr[i];
				i++;
			}else{
				if(arr[i] < 0 && arr[i+1] < 0){
					if(arr[i] > arr[i+1]){
						sum += arr[i];
						i++;
					}
					else{
						sum += arr[i+1];
						i++;
					}
				}else if(arr[i] < 0 && arr[i+1] > 0){
					sum += arr[i+1];
					i += 2;
				}
			}
		}
		System.out.print(sum);
	}
}

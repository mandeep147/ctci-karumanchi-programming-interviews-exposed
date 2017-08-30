/**
 * 
 */
package edu.mandeep.practice.interview;

/**Maximum difference between two elements such that larger
 * element appears after the smaller number
 * input: [2, 3, 10, 6, 4, 8, 1] 
 * output: 8 (Diff between 10 and 2)
 * @author mandeep
 */
public class MaxDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {2, 3, 10, 6, 4, 8, 1};
		//int[] arr = {4, 10, 20, 8, 5};
		int[] arr = {7, 9, 5, 6, 3, 2};
		maxDifference(arr);
	}
	
	
	/**
	 * Time Complexity: O(n)
	 * Space: O(1)
	 * @param arr
	 */
	private static void maxDifference(int[] arr){
		int maxDifference = arr[0] - arr[1];
		int minElement = arr[0];
		
		for(int i = 0; i < arr.length; i++){
			if(maxDifference < (arr[i] - minElement))
				maxDifference = arr[i] - minElement;
			if(minElement > arr[i])
				minElement = arr[i];
		}
		System.out.println(maxDifference);
	}
	
	//brute force
	/**
	 * Time Complexity: O(pow(n,2))
	 * Space: O(n)
	 * @param arr
	 */
	/**
	 private static void maxDifference(int[] arr){
		Map<Integer, Integer> difference = new HashMap<Integer, Integer>();
		int diff = 0; 
		int current;
		for(int i = 0; i < arr.length-1; i++){
			int j = i + 1;
			current = arr[i];
			while(j < arr.length - 1){
				int currentVal = arr[j];
				if(current < currentVal){
					diff = currentVal - current;
					if(difference.containsKey(current) && difference.get(current) < diff){
						difference.put(current, diff);
					}else if(difference.containsKey(current) && difference.get(current) > diff){
						difference.put(current, difference.get(current));
					}else if(!difference.containsKey(current)){
						difference.put(current, diff);
					}
				}
				j++;
			}
		}
		
		//TODO find largest value here
		for( Entry<Integer, Integer> e : difference.entrySet() ) {
	        System.out.println(e.getKey()+" "+e.getValue());
		}	
	}
	**/
}
package edu.mandeep.practice;

import java.util.StringTokenizer;
 
/* Name of the class has to be "Main" only if the class is public. */
class MinimumSquareRootSum
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] arr = new String[3];
		arr[0] = "1";
		arr[1] = "2 27";
		//arr[2] = "17 24";
 		int[] res = getMinimumUniqueSum(arr);
 		for(int i=0;i<res.length;i++) {
 			System.out.println(res[i]);
 		}
	}
 
	    static int[] getMinimumUniqueSum(String[] arr) {
        int numberOfTestCases = Integer.parseInt(arr[0]) + 1;
        int start = 0;
        int end = 0;
        int startSqrt = 0;
        int endSqrt = 0;
        int[] results = new int[arr.length - 1];
        @SuppressWarnings("unused")
		StringTokenizer st = null;
        while(numberOfTestCases-- > 1) {
            String[] arr1 = arr[numberOfTestCases].split(" ");
            start = Integer.parseInt(arr1[0]);
            end = Integer.parseInt(arr1[1]);
            startSqrt = (int) Math.floor(Math.sqrt(start));
            endSqrt = (int) Math.floor(Math.sqrt(end));
            results[numberOfTestCases - 1] = endSqrt - startSqrt;
        }
    	return results;
    }
 
}
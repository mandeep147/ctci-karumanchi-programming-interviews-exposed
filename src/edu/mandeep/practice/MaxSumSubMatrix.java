/**
 * Given a m * n matrix and value k. Find k * k matrix within the given matrix whose sum is maximum.
 * http://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class MaxSumSubMatrix {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, 1, 3, 4},
                {2, 1, 3, 1, 4},
                {1, 5, 6, 7, 8},
                {1, 2, 1, 2, 1}
               };
		int k = 2;
		printSum(mat, k);
	}
	
	private static void printSum(int[][] mat, int k){
		int m = mat.length;
		int n = mat[0].length;
		int sum = 0, i = 0, j = 0;
		int max = Integer.MIN_VALUE;
		
		int subMat[][] = new int[m - k + 1][n];
		
		for(j = 0; j < n; j++){
			sum = 0;
			for(i = 0; i < k; i++)
				sum += mat[i][j];
			
			subMat[0][j] = sum;
			
			for(i = 1; i < m - k + 1; i++){
				sum = sum + mat[i + k - 1][j] - mat[i-1][j];
				subMat[i][j] = sum;
			}
		}
		
		
		int rsum = 0, iindex = -1, jindex = -1;
		
		for(i = 0; i < m - k + 1; i++){
			rsum = 0;
			
			for(j = 0; j < k ; j++)
				rsum += subMat[i][j];
			
			if(rsum > max){
				max = rsum;
				iindex = i;
				jindex = j;
			}
			
			sum = rsum;
			
			for(j = 1; j < n - k + 1; j++){
				sum += (subMat[i][j + k - 1] - subMat[i][j-1]);
				
				if(sum > max){
					max = sum;
					iindex = i;
					jindex = j;
				}
			}
		}
		System.out.println(iindex);
		System.out.println(jindex);
		for(i = iindex; i < iindex + k; i++){
			for(j = jindex; j < jindex + k; j++)
				System.out.print(mat[i][j]+ " ");
			System.out.println();
		}
	}
}
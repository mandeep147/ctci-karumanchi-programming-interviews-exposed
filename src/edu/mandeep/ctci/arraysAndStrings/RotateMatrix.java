/**
 * Problem 1.7: Rotate Matrix
 * Given an image represented bu an N*N matrix, rotate the image by 90 degrees
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			};
		
		rotateMatrix(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 */
	private static void rotateMatrix(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length){
			
		}
		int n = matrix.length;
		for(int i = 0; i < n/2; i++){
			int first = i;
			int last = n - 1 - i;
			for(int j = first; j < last; j++){
				int temp = matrix[i][j];
                // move values from right to top
                matrix[i][j] = matrix[j][last];
                // move values from bottom to right
                matrix[j][last] = matrix[last][n-1-j];
                // move values from left to bottom
                matrix[last][n-1-j] = matrix[n-1-j][i];
                // assign temp to left
                matrix[n-1-j][i] = temp;
			}
		}
	}
}
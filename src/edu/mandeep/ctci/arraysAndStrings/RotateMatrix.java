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
				int offset = j - first;
				int top = matrix[first][j];
				
				//move left to top
				matrix[first][j] = matrix[last-offset][first];
				//bottom to left
				matrix[last-offset][first] = matrix[last][last-offset];
				//right to bottom
				matrix[last][last-offset] = matrix[j][last];
				//top to right
				matrix[j][last] = top;
			}
		}
	}
}
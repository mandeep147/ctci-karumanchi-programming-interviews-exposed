/**
 * 
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class MatrixMultiplicatio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9}
				};
		int[][] b = {
				{2, 3, 4},
				{5, 6, 7},
				{8, 9, 1}
		};
		
		int[][] result = matrixMultiplication(a, b);
		
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j <result[0].length; j++)
				System.out.print(result[i][j]+ " ");
			System.out.println();
		}
	}

	/**
	 * @param a
	 * @param b
	 */
	private static int[][] matrixMultiplication(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b[0].length; j++){
				int sum = 0;
				for(int k = 0; k < a.length; k++)
					sum += a[i][k] * b[k][j];
				
				c[i][j] = sum;
			}
		}
		return c;
	}
}
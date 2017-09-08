/**
 * 
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class ZeroMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZeroMatrix zero = new ZeroMatrix();
		int[][] matrix = {
				{0,1,1,4,0},
				{2,3,0,3,1},
				{3,5,6,2,5},
				{3,4,5,6,0}
			};
		zero.setZeros(matrix);
	}
	private void setZeros(int[][]matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			if(row[i])
				nullifyRow(matrix, i);
		}
		
		for(int j = 0; j < matrix[0].length; j++){
			if(column[j])
				nullifyColumn(matrix, j);
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	private void nullifyRow(int[][] matrix, int row){
		for(int j = 0; j < matrix[0].length; j++)
			matrix[row][j] = 0;
	}
	
	private void nullifyColumn(int[][] matrix, int column){
		for(int i = 0; i < matrix.length; i++)
			matrix[i][column] = 0;
	}
}

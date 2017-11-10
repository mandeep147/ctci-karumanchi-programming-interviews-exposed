/**
 * 
 */
package edu.mandeep.practice;

import java.util.Scanner;

/**
 * Count all possible paths from top left to bottom right of a mXn matrix
 *  from each cell you can either move only to right, down or diagonally downwards
 *  
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * @author mandeep
 */
public class NoOfPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		System.out.println(countPaths(m, n));
		System.out.println(countPathsDP(m, n));
	}
	
	private static int countPaths(int row, int col){
		if(row == 1 || col == 1)
			return 1;
		
		return countPaths(row - 1, col) + countPaths(row, col - 1) + countPaths(row - 1, col - 1);
	}
	
	private static int countPathsDP(int row, int col){
		int count[][] = new int[row][col];
		
		for(int i = 0; i < row; i++)
			count[i][0] = 1;
		
		for(int j = 0; j < col; j++)
			count[0][j] = 1;
		
		for(int i = 1; i < row; i++)
			for(int j = 1; j < col; j++)
				count[i][j] = count[i - 1][j] + count[i][j - 1] + count[i - 1][j - 1];
		
		return count[row - 1][col - 1];
	}
}
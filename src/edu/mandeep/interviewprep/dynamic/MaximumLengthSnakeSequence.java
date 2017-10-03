/**
 * You are given a grid of numbers. A snake sequence is made up of adjacent numbers such that for each number, 
 * the number on the right or the number below it is +1 or -1 its value. For example, 

1 3 2 6 8 
-9 7 1 -1 2 
1 5 0 1 9 

In this grid, (3, 2, 1, 0, 1) is a snake sequence. 

Given a grid, find the longest snake sequences and their lengths 
(so there can be multiple snake sequences with the maximum length).
 */
package edu.mandeep.interviewprep.dynamic;

import java.util.ArrayList;

/**
 * @author mandeep
 DP:
 dp[0][0] = 1;i = j = 0
 dp[i][j] = max(dp[i][j], dp[i-1][j]); abs(m[i][j] - m[i-1][j]) = 1
 dp[i][j] = max(dp[i][j], dp[i][j-1]); abs(m[i][j] - m[i][j-1]) = 1
 */
public class MaximumLengthSnakeSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] mat = {
				{1, 3, 2, 6, 8},
				{-9, 7, 1, -1, 2},
				{1, 5, 0, 1, 9}
		};
		//int[][] mat = {{ 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }};
		/**
{{1, 2, 1, 2},
                {7, 7, 2, 5},
                {6, 4, 3, 4},
                {1, 2, 2, 5}};**/
		maximumSnakeLengthSequence(mat);

	}

	/**
	 * Space/Time complexity O(n*m)
	 * @param mat
	 */
	private static void maximumSnakeLengthSequence(int[][] mat) {
		int rows = mat.length;
		int col = mat[0].length;
		int maxLen = 0;
		int maxRow = 0, maxCol = 0;
		
		int[][] result = new int[rows][col];
		
		//if no sequence is found
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < col; j++)
				result[i][j] = 1;
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < col; j++){
				if( i == 0 && j == 0){
					continue;
				}
				if( i > 0 && Math.abs(mat[i-1][j] - mat[i][j]) == 1){
					result[i][j] = Math.max(result[i][j], result[i-1][j] + 1);
					maxLen = Math.max(maxLen, result[i][j]);
					maxRow = i;
					maxCol = j;
				}
					
				if( j > 0 && Math.abs(mat[i][j-1] - mat[i][j]) == 1){
					result[i][j] = Math.max(result[i][j], result[i][j-1] + 1);
					maxLen = Math.max(maxLen, result[i][j]);
					maxRow = i;
					maxCol = j;
				}
			}
		}
		
		System.out.println("Max snake sequence: " +maxLen);
		printPath(mat, result, maxLen, maxRow, maxCol);
	}

	/**
	 * @param mat
	 * @param result
	 * @param maxLen
	 * @param maxRow
	 * @param maxCol
	 */
	private static void printPath(int[][] mat, int[][] result, int maxLen, int maxRow, int maxCol) {
		ArrayList<Integer> snake = new ArrayList<Integer>();
		snake.add(mat[maxRow][maxCol]);
		
		while(result[maxRow][maxCol] != 1){
			if(maxRow > 0 && maxCol > 0 ){
				if(result[maxRow][maxCol] == result[maxRow - 1][maxCol] + 1){
					snake.add(mat[maxRow-1][maxCol]);
					maxRow--;
				} else if(result[maxRow][maxCol] == result[maxRow][maxCol  - 1] + 1){
					snake.add(mat[maxRow][maxCol - 1]);
					maxCol--;
				}
			}else if(maxCol == 0){
				if(result[maxRow][maxCol] == result[maxRow - 1][maxCol] + 1){
					snake.add(mat[maxRow-1][maxCol]);
					maxRow--;
				} 
			}else if(maxRow == 0){
				if(result[maxRow][maxCol] == result[maxRow][maxCol  - 1] + 1){
					snake.add(mat[maxRow][maxCol - 1]);
					maxCol--;
				}
			}
		}
		System.out.println(snake);
	}
}
/**
 * 
 */
package edu.mandeep.interview;

import java.util.Scanner;

/**
 * Check whether given n by n is a valid sudoku solution
 * @author mandeep
 */
public class ValidateSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] board = new int[9][9];
		System.out.println("enter soduku solution to check validity: ");
		for(int i = 0; i < 9 ; i++)
			for(int j = 0; j < 9; j++)
				board[i][j] = in.nextInt();
		
		System.out.println("Given sudoku soluntion is a ");
		System.out.print(validateSudoku(board)?"Valid Solution":"Not a valid soltuion");
				
	}
	
	private static boolean validateSudoku(int[][] board){
		
		for(int i = 0; i < 9 ; i++)
			for(int j = 0; j < 9; j++)
				if(board[i][j] < 1 || board[i][j] > 9 || !validateSudoku(board, i, j))
					return false;
		
		return true;
	}

	private static boolean validateSudoku(int[][] board, int i, int j) {
		
		for(int column = 0; column < 9; column++)
			if(column != j && board[i][column] == board[i][j])
				return false;
		
		for(int row = 0; row < 9; row++)
			if(row != i && board[row][j] == board[i][j])
				return false;
		
		for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
			for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
				if(row != i && col != j && board[row][col] == board[i][j])
					return false;
		
		return true;
	}
}
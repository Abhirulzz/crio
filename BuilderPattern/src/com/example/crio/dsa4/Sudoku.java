package com.example.crio.dsa4;

import java.util.HashSet;

public class Sudoku {
	
	
	    
		public boolean isValidSudoku(char[][] board) {
			for(int i=0;i<9;i++)
		     {
		         for(int j=0;j<9;j++)//traverse in bfs manner 
		         {
		             char ch=board[i][j];
		             if(ch!='.')//if ch is apart from '.'we need to check whether the given number is verifiable
		             {
		                 board[i][j]='.';//change it to . so that it cannot consider itself
		                 if(!isValid(board,ch,i,j))//if not verifiable
		                     return false;//invalid sudoku
		                 board[i][j]=ch;//after checking change it to its initial value
		             }
		         }
		     }
		        return true;
		    }
		    static boolean isValid(char[][]ch,char ch1,int i,int j)
		    {
		      for(int k=0;k<9;k++)
		      {
		          if(ch[i][k]==ch1)return false;//for checking row associated with it
		          if(ch[k][j]==ch1)return false;//for checking column associated with it
		          if(ch[3*(i/3)+k/3][3*(j/3)+k%3]==ch1)return false;//for checking block associated with it
		      }
		        return true;
		    }
	    
	    
	    private boolean isValidSudokuHelper(char[][] board, int row, int col) {
	        // If we've reached the end of the board, it's valid
	        if (row == 9) {
	            return true;
	        }
	        
	        // Move to the next row if we've reached the end of the current row
	        if (col == 9) {
	            return isValidSudokuHelper(board, row + 1, 0);
	        }
	        
	        // Skip filled cells
	        if (board[row][col] != '.') {
	            return isValidSudokuHelper(board, row, col + 1);
	        }
	        
	        // Try placing numbers from '1' to '9' in the current cell
	        for (char num = '1'; num <= '9'; num++) {
	            if (isValidMove(board, row, col, num)) {
	                board[row][col] = num;
	                if (isValidSudokuHelper(board, row, col + 1)) {
	                    return true;
	                }
	                // Backtrack
	                board[row][col] = '.';
	            }
	        }
	        
	        // No valid number found for the current cell
	        return false;
	    }
	    
	    private boolean isValidMove(char[][] board, int row, int col, char num) {
	        // Check if num is already present in the current row or column
	        for (int i = 0; i < 9; i++) {
	            if (board[row][i] == num && i != col || board[i][col] == num && i != row) {
	                return false;
	            }
	        }
	        
	        // Check if num is already present in the current 3x3 subgrid
	        int startRow = (row / 3) * 3;
	        int startCol = (col / 3) * 3;
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[startRow + i][startCol + j] == num && (startRow + i != row || startCol + j != col)) {
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	    
	  
	    public static void main(String[] args) {
	        // Example usage
	        char[][] sudoku = {
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
	            {'1', '1', '1', '1', '1', '1', '1', '1', '1'}
	        };
	        
	        Sudoku validator = new Sudoku();
	        System.out.println("Is the Sudoku valid? " + validator.isValidSudoku(sudoku));
	    }
	}




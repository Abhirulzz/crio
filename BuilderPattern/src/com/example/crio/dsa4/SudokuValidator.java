package com.example.crio.dsa4;
public class SudokuValidator {
    
	public boolean isValidSudoku(char[][] board) {
        return isValidSudokuHelper(board, 0, 0);
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
        
        SudokuValidator validator = new SudokuValidator();
        System.out.println("Is the Sudoku valid? " + validator.isValidSudoku(sudoku));
    }
}

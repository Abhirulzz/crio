package com.example.crio.dsa4;

public class NQueenProblem {
	
	    private int[] queens; // Store the column position of each queen

	    public String solveNQueens(int n) {
	        queens = new int[n];
	        StringBuilder result = new StringBuilder();

	        if (solveNQueensUtil(0, n, result)) {
	            return result.toString();
	        } else {
	            return "No solution exists!";
	        }
	    }

	    private boolean solveNQueensUtil(int row, int n, StringBuilder result) {
	        if (row == n) {
	            // All queens are placed successfully
	            generateBoard(n, result);
	            return true;
	        }

	        for (int col = 0; col < n; col++) {
	            if (isSafe(row, col)) {
	                queens[row] = col;
	                if (solveNQueensUtil(row + 1, n, result)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private boolean isSafe(int row, int col) {
	        for (int i = 0; i < row; i++) {
	            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private void generateBoard(int n, StringBuilder result) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (queens[i] == j) {
	                    result.append("1");
	                } else {
	                    result.append("0");
	                }
	            }
	            result.append("\n");
	        }
	    }

	    public static void main(String[] args) {
	        int n = 4; // Change n to the desired board size
	        NQueenProblem nQueensProblem = new NQueenProblem();
	        System.out.println(nQueensProblem.solveNQueens(n));
	    }
	}



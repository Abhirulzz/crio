package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {

	    public static String solveNQueens(int n) {
	        char[][] board = new char[n][n];
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n; j++)
	                board[i][j] = '0';
	        List < List < String >> res = new ArrayList < List < String >> ();
	        StringBuilder result = new StringBuilder();
	        if (dfs(0, board, res,result))
	        return result.toString();
	        else
	        	return "No Solution Exists";
	    }

	    static boolean validate(char[][] board, int row, int col) {
	        int duprow = row;
	        int dupcol = col;
	        while (row >= 0 && col >= 0) {
	            if (board[row][col] == '1') return false;
	            row--;
	            col--;
	        }

	        row = duprow;
	        col = dupcol;
	        while (col >= 0) {
	            if (board[row][col] == '1') return false;
	            col--;
	        }

	        row = duprow;
	        col = dupcol;
	        while (col >= 0 && row < board.length) {
	            if (board[row][col] == '1') return false;
	            col--;
	            row++;
	        }
	        return true;
	    }

	    static boolean dfs(int col, char[][] board, List < List < String >> res,StringBuilder result) {
	        if (col == board.length) {
	            res.add(construct(board));
	            generateBoard(board,result);
	            return true;
	        }

	        for (int row = 0; row < board.length; row++) {
	            if (validate(board, row, col)) {
	                board[row][col] = '1';
	                dfs(col + 1, board, res,result);
	                board[row][col] = '0';
	            }
	        }
	        return false;
	    }


	    private static void generateBoard(char[][] board, StringBuilder result) {
	        for (int i = 0; i < board.length; i++) {
	           
	                    result.append(new String(board[i]));
	                    result.append("\n");
	            }
	            //result.append("\n");
	        }
	    
	    
	    static List < String > construct(char[][] board) {
	        List < String > res = new LinkedList < String > ();
	        for (int i = 0; i < board.length; i++) {
	            String s = new String(board[i]);
	            res.add(s);
	        }
	        return res;
	    }
	    public static void main(String args[]) {
	        int N = 2;
	        String NQueen = solveNQueens(N);
	        /*List < List < String >> queen = solveNQueens(N);
	        int i = 1;
	        for (List < String > it: queen) {
	            System.out.println("Arrangement " + i);
	            for (String s: it) {
	                System.out.println(s);
	            }
	            System.out.println();
	            i += 1;
	        }*/
	     System.out.println("NQueen" + NQueen);   
	    }
	}



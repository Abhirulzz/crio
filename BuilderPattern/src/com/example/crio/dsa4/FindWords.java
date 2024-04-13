package com.example.crio.dsa4;

public class FindWords {

	    public boolean exist(char[][] board, String word) {
	        if (board == null || board.length == 0 || word == null || word.length() == 0)
	            return false;

	        int rows = board.length;
	        int cols = board[0].length;
	        boolean[][] visited = new boolean[rows][cols];

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (dfs(board, visited, i, j, word, 0))
	                    return true;
	            }
	        }

	        return false;
	    }

	    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
	        if (index == word.length())
	            return true;

	        int rows = board.length;
	        int cols = board[0].length;

	        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || board[row][col] != word.charAt(index))
	            return false;

	        visited[row][col] = true;

	        boolean result = dfs(board, visited, row + 1, col, word, index + 1) ||
	                         dfs(board, visited, row - 1, col, word, index + 1) ||
	                         dfs(board, visited, row, col + 1, word, index + 1) ||
	                         dfs(board, visited, row, col - 1, word, index + 1);

	        visited[row][col] = false;

	        return result;
	    }

	    public static void main(String[] args) {
	    	FindWords wordSearch = new FindWords();
	        char[][] board = {
	            {'A', 'B', 'C', 'E'},
	            {'S', 'F', 'C', 'S'},
	            {'A', 'D', 'E', 'E'}
	        };
	        String word1 = "ABCCED";
	        String word2 = "SEE";
	        String word3 = "ABCB";

	        System.out.println("Word \"ABCCED\" exists on the board: " + wordSearch.exist(board, word1));
	        System.out.println("Word \"SEE\" exists on the board: " + wordSearch.exist(board, word2));
	        System.out.println("Word \"ABCB\" exists on the board: " + wordSearch.exist(board, word3));
	    }
	}

	


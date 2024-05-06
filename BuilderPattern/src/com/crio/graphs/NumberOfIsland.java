package com.crio.graphs;

import java.util.ArrayList;

public class NumberOfIsland {
	
	public static int numIslands(ArrayList<String> grid) {
		
		int r = grid.size();
        int c = grid.get(0).length(); // Assuming all rows have the same number of columns

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            String elements = grid.get(i);
            for (int j = 0; j < c; j++) {
            	int start = j;
                matrix[i][j] = Integer.parseInt(elements.substring(start,start+1));
            }
        }
        
        int count = 0;
		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {
				
				if(matrix[i][j] == 1)
				{
					markisland(i, j, matrix, r, c);
					count++;
				}

			}
		}
        return count;
	}
        public static void markisland(int i,int j,int[][] matrix,int  r , int c) {
        	
        	if(i < 0 || j < 0 || i >=r || j >=c || matrix[i][j] != 1 )
        	{
        		return;
        	}
        	matrix[i][j] = 2;
        	markisland(i, j+1,matrix, r ,c);
        	markisland(i+1, j,matrix, r ,c);
        	markisland(i, j-1,matrix, r ,c);
        	markisland(i-1, j,matrix, r ,c);
        	
        }
        
        public static int[][] convertToMatrix(ArrayList<String> stringList) {
            int numRows = stringList.size();
            int numCols = stringList.get(0).length(); // Assuming all rows have the same number of columns

            int[][] matrix = new int[numRows][numCols];

            for (int i = 0; i < numRows; i++) {
                String elements = stringList.get(i);
                for (int j = 0; j < numCols; j++) {
                	int start = j;
                    matrix[i][j] = Integer.parseInt(elements.substring(start,start+1));
                }
            }

            return matrix;
        }

        
        public static void main(String[] args) {
            ArrayList<String> stringList = new ArrayList<>();
            stringList.add("11110");
            stringList.add("11010");
            stringList.add("11000");
            stringList.add("11000");
            
            
            
            int[][] matrix = convertToMatrix(stringList);
            // Convert ArrayList of strings to 2D matrix
            printMatrix(matrix);
            int count = numIslands(stringList);

            
            System.out.println("Count"+ count);
            // Print the resulting matrix
            
        
    }
        
        public static void printMatrix(int[][] matrix) {
            int numRows = matrix.length;
            int numCols = matrix[0].length;

            System.out.println("Matrix:");
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

}

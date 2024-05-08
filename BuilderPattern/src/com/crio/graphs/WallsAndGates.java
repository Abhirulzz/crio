package com.crio.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class WallsAndGates {
	
public static int[][] wallsAndGates(int [][] grid ) {


	Queue<Node> q = new ArrayDeque<>();
	int r = grid.length;
	int c = grid[0].length; // Assuming all rows have the same number of columns

	for (int i = 0; i < r; i++) {

		for (int j = 0; j < c; j++) {

			if (grid[i][j]== 0) {
				q.add(new Node(i, j, 0));
			}

		}
	}
	

	int[] dr = { -1, 0, +1, 0 };
	int[] dc = { 0, +1, 0, -1 };

	while (q.size() != 0) {
		Node curr = q.remove();

		for (int idx = 0; idx < 4; idx++) {
			int i = curr.r + dr[idx];
			int j = curr.c + dc[idx];

			if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == -1 )
				continue;

			if (grid[i][j] == Integer.MAX_VALUE) {
				
				grid[i][j] = curr.time + 1;
			
				q.add(new Node(i, j, curr.time + 1));
				

			}

		}
	}


	return grid;


			}

public static void main(String[] args) {
    // Example input: list of edges represented as list of lists
	int[][] graphData = {
            {Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE} 
            ,{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1}
            ,{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1} ,
            {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
            
      };
	//GraphIsTree pathFinder = new GraphIsTree();
	for (int[] row : graphData)
  	  
        // converting each row as string
        // and then printing in a separate line
        System.out.println(Arrays.toString(row));

      int[][] result = wallsAndGates(graphData);
      
      
          // Loop through all rows
             for (int[] row : result)
        	  
              // converting each row as string
              // and then printing in a separate line
              System.out.println(Arrays.toString(row));
      
      }
      
      
    
}





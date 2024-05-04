package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAreaOfIsland {
	
	public static int maxAreaOfIsland(List<List<Integer> > grid){

		
		int r = grid.size();
        int c = grid.get(0).size(); // Assuming all rows have the same number of columns

       
        int max = 0;
		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {
				
				if(grid.get(i).get(j) == 1)
				{
					
					max = Math.max(max ,markisland(i, j,grid, r ,c)) ;
				 
				 
				}

			}
		}
        return max;
	
	}
	
	public static int markisland(int i,int j,List<List<Integer> > grid,int  r , int c) {
    	
    	if(i < 0 || j < 0 || i >=r || j >=c || grid.get(i).get(j) != 1 )
    	{
    		return 0;
    	}
    	grid.get(i).set(j, 2); 
    	int count=1;
    	count +=markisland(i, j+1,grid, r ,c);
    	count +=markisland(i+1, j,grid, r ,c);
    	count +=markisland(i, j-1,grid, r ,c);
    	count +=markisland(i-1, j,grid, r ,c);
    	
    	return count;
    	
    }
		
		public static void main(String[] args) {
			// Example input: list of edges represented as list of lists
			List<List<Integer>> list = new ArrayList<>();
			

			list.add(Arrays.asList(1 ,1 ,0, 0, 0));
			list.add(Arrays.asList(0 ,1, 0, 0, 1));
			list.add(Arrays.asList(0 ,0 ,1, 1, 1));
			List<List<Integer>> edges = new ArrayList<>(list); 
			int nodes = 0;
			for (List<Integer> edge : edges) {
				nodes = Math.max(nodes, edge.get(0));
				nodes = Math.max(nodes, edge.get(1));
			}
			//MaxAreaOfIsland pathFinder = new MaxAreaOfIsland();

			int result = maxAreaOfIsland(edges);
			System.out.println(result);

		}
    

}

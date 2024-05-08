package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NearestCity {
	
	    public static  ArrayList<Integer> findTheCity(int n, ArrayList<ArrayList<Integer>>  edges, ArrayList<Integer> src) {
	        int[][] matrix = new int[n+1][n+1];
	        
	        // Initialize the matrix
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <=n; j++) {
	                if (i == j) {
	                    matrix[i][j] = 0; // Distance from a city to itself is zero
	                } else {
	                    matrix[i][j] = Integer.MAX_VALUE / 2; // Large value representing no direct connection
	                }
	            }
	        }

	        // Populate the matrix with edge values
	        for (ArrayList<Integer> edge : edges) {
	            int a = edge.get(0);
	            int b = edge.get(1);
	            //int cost = edge[2];
	            matrix[a][b] = 1;
	            matrix[b][a] = 1;
	        }

	        // Apply Floyd-Warshall algorithm to compute shortest paths
	        for (int k = 1; k <= n; k++) {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                    int newCost = matrix[i][k] + matrix[k][j];
	                    if (newCost < matrix[i][j]) {
	                        matrix[i][j] = newCost;
	                    }
	                }
	            }
	        }

	        // Determine the city with the fewest neighbors within the threshold
	       
	       ArrayList<Integer> ans = new ArrayList<>();;
	       int minDist[] = new int[n+1];
	   		Arrays.fill(minDist, Integer.MAX_VALUE);
	        for (int i = 1; i <= n; i++) {
	            int count = 0;
	            for (int j : src) {
	                if (matrix[i][j] == 0) {
	                    //ans.add(0);
	                    minDist[i]=0;
	                }else if(matrix[i][j] <= minDist[i]) 
	                {
	                	//ans.add(j);
	                	minDist[i]=matrix[i][j];
	                }
	            }
	           
	        }
	        for (int i = 1; i <= n; i++) {
	        ans.add(minDist[i]);
	        }

	        return ans;
	    }
	    
	    public static void main(String[] args) {
	       
			int[][] graphData = {
		            {1,2} ,{2,3} ,{3,4},{4,2},{1,3}   
		         		      };
			
			int[] src = {1,4};
		            			
			ArrayList<Integer> result = new ArrayList<>();;
	          result = findTheCity(4,graphData,src);
	            System.out.println(result);
	        
		}
	    
	}



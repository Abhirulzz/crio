package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Police {
	  public static ArrayList<Integer> townsAndPoliceStations(int n,List<List<Integer> >  edges,List<Integer> src){

		  HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
			for (int i = 1; i <= n; i++) {
				adj.put(i, new ArrayList<>());
			}

			for (List<Integer> city : edges) {
				adj.get(city.get(0)).add(city.get(1));
				adj.get(city.get(1)).add(city.get(0));
				// adj.put(src.get(0),new ArrayList<>());
			}

			Queue<Integer> q = new LinkedList<>();
	  

	        int [] dist = new int[n+1];
	        Arrays.fill(dist, -1);
	        
	        boolean [] visited = new boolean[n+1];
	       // Arrays.fill(dist, -1);
	        
	        for (int i = 0; i < src.size(); i++) {
				
						q.add(src.get(i));
						dist[src.get(i)] =0;
						visited[src.get(i)]= true;
					}
			 // BFS traversal
	        while (!q.isEmpty()) {
	            int city = q.remove();

	            for (int neighbor : adj.get(city)) {
	            	
	                if (!visited[neighbor]){
	                	visited[neighbor]= true;
	                    dist[neighbor] = dist[city] +1;
	                    q.add(neighbor);
	                }
	                	                
	            }
	        }
	        ArrayList<Integer> ans = new ArrayList<>();
	        for (int i = 1; i <= n; i++) {
		        ans.add(dist[i]);
		        }

		        return ans;
		
	    }
	  
	
	  public static void main(String[] args) {
	        // Example input: list of edges represented as list of lists
	        List<List<Integer>> edges = new ArrayList<>();
	        edges.add(Arrays.asList(1,2));
	        edges.add(Arrays.asList(2, 3));
	        edges.add(Arrays.asList(3, 4));
	        edges.add(Arrays.asList(4, 2));
	        edges.add(Arrays.asList(2,5));
	        edges.add(Arrays.asList(3,6));
	        
	        int[][] graphData = {
		            {1,2} ,{2,3} ,{3,4},{4,2},{1,3}   
		         		      };
			
			//int[] src = {1,4};
	        int nodes  =0;
	        for (List<Integer> edge : edges) {
	            nodes = Math.max(nodes, edge.get(0));
	            nodes = Math.max(nodes, edge.get(1));
	        }
	        //Bipartite pathFinder = new Bipartite();
	        ArrayList<Integer> src = new ArrayList<>();
	        src.add(1);
	        src.add(4);
	        ArrayList<Integer> result = townsAndPoliceStations(nodes,edges,src);
	            System.out.println(result);
	        
	    }

}

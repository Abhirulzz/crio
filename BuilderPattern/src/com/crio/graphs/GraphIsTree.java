package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GraphIsTree {
	
	 int graphValidTree(int n, int[][] edges){
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i <= n; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (int[] src : edges) {
			adj.get(src[0]).add(src[1]);
			adj.get(src[1]).add(src[0]);
			// adj.put(src.get(0),new ArrayList<>());
		}

		boolean[] vis = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			if (vis[i] == true)
				continue;

			if (hasCycle(i, -1, adj, vis) == true) {
				return 0;
			}
			
			for(int u=0;u<=n;u++)
			{
				if(!vis[u])
					return 0;
			}

		}
		return 1;
    }
	
	public  static boolean hasCycle(int src, int parent, HashMap<Integer,List<Integer>> adj,boolean[] vis )
	{
		 if (vis[src] == true)
		 
		 return true;
		 
		 
		 vis[src] = true;
		 
		 for (int nbr: adj.get(src))
		 {
			 if(nbr== parent)
				 continue;
			 
			 if (hasCycle(nbr, src, adj, vis) == true) {
					return  true;
				}
		
		 }
				 
		return false;
	}
	

	public static void main(String[] args) {
        // Example input: list of edges represented as list of lists
		int[][] graphData = {
	            {5, 4},     // Node 0 has outgoing edges to node 1
	            {0, 1},     // Node 1 has outgoing edges to node 2
	            {0, 2},     // Node 2 has outgoing edges to node 0
	            {0, 3},     // Node 3 has outgoing edges to node 4
	            {0, 4}      // Node 5 has outgoing edges to node 3
	        };
		GraphIsTree pathFinder = new GraphIsTree();

          int result = pathFinder.graphValidTree(graphData.length,graphData);
            System.out.println(result);
        
	}
}

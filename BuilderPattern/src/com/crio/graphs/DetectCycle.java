package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DetectCycle {
	
	public  String FindCycle(int nodes,List<List<Integer>> edges)
	{
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= nodes; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (List<Integer> src : edges) {
			adj.get(src.get(0)).add(src.get(1));
			adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}

		boolean[] vis = new boolean[nodes + 1];
		for (int i = 1; i <= nodes; i++) {
			if (vis[i] == true)
				continue;

			if (hasCycle(i, -1, adj, vis) == true) {
				return "Yes";
			}

		}
		return "No";
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
        List<List<Integer>> edges = new ArrayList<>();
       //dges.add(Arrays.asList(1, 2));
       //dges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 1));
        //edges.add(Arrays.asList(2, 3));
        int nodes  =0;
        for (List<Integer> edge : edges) {
            nodes = Math.max(nodes, edge.get(0));
            nodes = Math.max(nodes, edge.get(1));
        }
        DetectCycle pathFinder = new DetectCycle();

          String result = pathFinder.FindCycle(nodes,edges);
            System.out.println(result);
        
    }

}

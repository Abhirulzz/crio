package com.crio.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
	
	public static boolean courseSchedule(int numCourses, int[][] prerequisites) {

		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= prerequisites.length; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (int[] src : prerequisites) {
			adj.get(src[0]).add(src[1]);
			// adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}

		boolean[] vis = new boolean[prerequisites.length + 1];
		boolean[] pathVis = new boolean[prerequisites.length + 1];
		for (int i = 1; i <= prerequisites.length; i++) {
			if (!vis[i])
				if (hasCycle(i, adj, vis, pathVis)) {
					return false;
				}

		}
		return true;
	
	  }
	public static boolean hasCycle(int src, HashMap<Integer, List<Integer>> adj, boolean[] vis, boolean[] pathVis) {

		vis[src] = true;
		pathVis[src] = true;

		for (int nbr : adj.get(src)) {
			if (!vis[nbr]) {
				if (hasCycle(nbr, adj, vis, pathVis)) {
					return true;
				}
			} else if (pathVis[nbr]) {
				return true;
			}
		}

		pathVis[src] = false;

		return false;
	}
	
	public static void main(String[] args) {
        // Example input: list of edges represented as list of lists
		int[][] graphData = {
	            {2, 1}     // Node 0 has outgoing edges to node 1
	               // Node 5 has outgoing edges to node 3
	        };
		//GraphIsTree pathFinder = new GraphIsTree();

          boolean result = courseSchedule(2,graphData);
            System.out.println(result);
        
	}

}

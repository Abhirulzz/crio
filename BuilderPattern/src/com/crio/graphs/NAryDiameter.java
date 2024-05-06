package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class NAryDiameter {
	    int maxDiameter;
	    
	    public int diameterOfTree(int n,List<List<Integer> > edges)
		{
	    	
	    	HashMap<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
			for (int i = 1; i <= n; i++) {
				tree.put(i, new ArrayList<>());
			}

			for (List<Integer> src : edges) {
				tree.get(src.get(0)).add(src.get(1));
				tree.get(src.get(1)).add(src.get(0));
				// adj.put(src.get(0),new ArrayList<>());
			}
	        if (tree == null || tree.isEmpty()) return 0;
	        maxDiameter = 0;
	        dfs(tree, 1, -1); // Start DFS from node 1 (assuming root is node 1)
	        return maxDiameter;
	    }

	    private int dfs(Map<Integer, List<Integer>> tree, int node, int parent) {
	        if (!tree.containsKey(node)) return 0;

	        // Keep track of the two maximum depths from this node
	        int firstMaxDepth = 0;
	        int secondMaxDepth = 0;

	        for (int child : tree.get(node)) {
	            if (child != parent) {
	                int childDepth = dfs(tree, child, node);
	                if (childDepth > firstMaxDepth) {
	                    secondMaxDepth = firstMaxDepth;
	                    firstMaxDepth = childDepth;
	                } else if (childDepth > secondMaxDepth) {
	                    secondMaxDepth = childDepth;
	                }
	            }
	        }

	        // Update the maximum diameter found so far
	        int currentDiameter = firstMaxDepth + secondMaxDepth;
	        maxDiameter = Math.max(maxDiameter, currentDiameter);

	        // Return the maximum depth from this node
	        return 1 + firstMaxDepth;
	    }

	    public static void main(String[] args) {
	        // Example usage with HashMap representing an N-ary tree
	    	 List<List<Integer>> edges = new ArrayList<>();
	         edges.add(Arrays.asList(1, 2));
	         edges.add(Arrays.asList(1, 3));
	         edges.add(Arrays.asList(4, 1));
	         //edges.add(Arrays.asList(4, 2));
	         //edges.add(Arrays.asList(2, 5));
	         
	       
	         int nodes  =0;
	         for (List<Integer> edge : edges) {
	             nodes = Math.max(nodes, edge.get(0));
	             nodes = Math.max(nodes, edge.get(1));
	         }
	         NAryDiameter pathFinder = new NAryDiameter();

	           int result = pathFinder.diameterOfTree(nodes,edges);
	        //int result = treeDiameter.diameter(tree);
	        System.out.println("Diameter of the tree: " + result);
	    }
	}




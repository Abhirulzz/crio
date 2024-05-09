package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Topo {
	
	    private static void dfs(int node, int vis[], Stack<Integer> st,
	    		HashMap<Integer, List<Integer>> adj) {
	        vis[node] = 1;
	        for (int it : adj.get(node)) {
	            if (vis[it] == 0)
	                dfs(it, vis, st, adj);
	        }
	        st.push(node);
	    }

	    // Function to return list containing vertices in Topological order.
	    static int[] topoSort(int V, List<List<Integer>> edges) {
	    	
	    	HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
			for (int i = 1; i <= V; i++) {
				adj.put(i, new ArrayList<>());
			}

			for (List<Integer> src : edges) {
				adj.get(src.get(0)).add(src.get(1));
				//adj.get(src.get(1)).add(src.get(0));
				// adj.put(src.get(0),new ArrayList<>());
			}

	        int vis[] = new int[V+1];
	        Stack<Integer> st = new Stack<Integer>();
	        for (int i = 1; i <= V; i++) {
	        	
	            if (vis[i] == 0) {
	                dfs(i, vis, st, adj);
	            }
	        }

	        int ans[] = new int[V+1];
	        int i = 0;
	        while (!st.isEmpty()) {
	            ans[i++] = st.peek();
	            st.pop();
	        }
	        return ans;
	    }

	
	    public static void main(String[] args) {
	        // Example input: list of edges represented as list of lists
	        List<List<Integer>> edges = new ArrayList<>();
	        edges.add(Arrays.asList(1, 2));
	        edges.add(Arrays.asList(2, 1));
	        //edges.add(Arrays.asList(1, 3));
	        //edges.add(Arrays.asList(4, 2));
	        //edges.add(Arrays.asList(2, 5));
	        
	      
	        int nodes  =0;
	        for (List<Integer> edge : edges) {
	            nodes = Math.max(nodes, edge.get(0));
	            nodes = Math.max(nodes, edge.get(1));
	        }
	        //Bipartite pathFinder = new Bipartite();

	          int[] result = topoSort(nodes,edges);
	          for (int node : result) {
	              System.out.print(node + " ");
	          }
	          System.out.println("");
	        
	    }
	}




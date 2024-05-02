package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;

class TakeYouForward {
	    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
	        vis[node] = 1; 
	        pathVis[node] = 1; 
	        
	        // traverse for adjacent nodes 
	        for(int it : adj.get(node)) {
	            // when the node is not visited 
	            if(vis[it] == 0) {
	                if(dfsCheck(it, adj, vis, pathVis) == true) 
	                    return true; 
	            }
	            // if the node has been previously visited
	            // but it has to be visited on the same path 
	            else if(pathVis[it] == 1) {
	                return true; 
	            }
	        }
	        
	        pathVis[node] = 0; 
	        return false; 
	    }

	    // Function to detect cycle in a directed graph.
	    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
	        int vis[] = new int[V];
	        int pathVis[] = new int[V];
	        
	        for(int i = 0;i<V;i++) {
	            if(vis[i] == 0) {
	                if(dfsCheck(i, adj, vis, pathVis) == true) return true; 
	            }
	        }
	        return false; 
	    }
	

	
	    public static void main(String[] args) {
	        int V = 11;
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            adj.add(new ArrayList<>());
	        }
	        adj.get(1).add(2);
	        adj.get(4).add(1);
	        adj.get(2).add(4);
	       
	        TakeYouForward obj = new TakeYouForward();
	        boolean ans = obj.isCyclic(V, adj);
	        if (ans)
	            System.out.println("True");
	        else
	            System.out.println("False");

	    }
	}



package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BuildProject {
	
	
		
		    private static boolean dfs(int node, int vis[], Stack<String> st,
					HashMap<String, List<String>> adj, List<String> proj) {
				vis[node] = 1;
				for (String it : adj.get(proj.get(node))) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).equals(it)) {
							if (vis[i] == 0)
								if(dfs(i, vis, st, adj, proj))
							return false;
						}
					}
				}
				st.push(proj.get(node));
				return true;
			}

		    // Function to return list containing vertices in Topological order.
		    static  ArrayList<String>topoSort( ArrayList<String> proj,List<List<String>> edges) {
		    	int V = proj.size();
		    	HashMap<String, List<String>> adj = new HashMap<String, List<String>>();
				for (int i = 0; i <V; i++) {
					adj.put(proj.get(i), new ArrayList<>());
				}

				for (List<String> src : edges) {
					adj.get(src.get(0)).add(src.get(1));
					//adj.get(src.get(1)).add(src.get(0));
					// adj.put(src.get(0),new ArrayList<>());
				}

		        int vis[] = new int[V];
		        Stack<String> st = new Stack<String>();
		        for (int i = 0; i < V; i++) {
		            if (vis[i] == 0) {
		                if(!dfs(i, vis, st, adj,proj))
		                {
		                	ArrayList<String> ans = new ArrayList<>();
		    		       // int i = 0;
		    		        while (!st.isEmpty()) {
		    		            ans.add( st.peek());
		    		            st.pop();
		    		        }
		    		        return ans;
		                }
		                	
		            }
		        }
		        ArrayList<String> ans = new ArrayList<>();
		        ans.add("-1");
		        return ans;
		    }

		
		    public static void main(String[] args) {
		        // Example input: list of edges represented as list of lists
		        List<List<String>> edges = new ArrayList<>();
		        edges.add(Arrays.asList("1", "2"));
		        edges.add(Arrays.asList("2", "1"));
		        //edges.add(Arrays.asList("1", "3"));
		        //edges.add(Arrays.asList("4", "2"));
		        //edges.add(Arrays.asList("2", "5"));
		        
		        ArrayList<String> proj = new ArrayList<>();
		        //proj.add("5");
		        proj.add("1");
		        proj.add("2");
		        //proj.add("3");
		        //proj.add("4");
		       // int nodes  =0;
		        //for (List<String> edge : edges) {
		         //   nodes = Math.max(nodes, edge.get(0));
		          //  nodes = Math.max(nodes, edge.get(1));
		        //}
		        //Bipartite pathFinder = new Bipartite();

		        ArrayList<String> result = topoSort(proj,edges);
		          for (String node : result) {
		              System.out.print(node + " ");
		          }
		          System.out.println("");
		        
		    }
		}







package com.crio.graphs;

import java.util.*;

class PoliceStation {

	// This array stores the distances of the vertices
	// from the nearest source
	static int[] dist;
	
	static int[] near;

	// This Set contains the vertices not yet visited in
	// increasing order of distance from the nearest source
	// calculated till now
	static Set<Map.Entry<Integer, Integer> > Q
		= new HashSet<>();

	// Util function for Multi-Source BFS
	static void multiSourceBFSUtil(List<Integer>[] graph,
								int s)
	{
		Iterator<Map.Entry<Integer, Integer> > it;
		for (int i = 0; i < graph[s].size(); i++) {
			int v = graph[s].get(i);
			if (dist[s] + 1 < dist[v]) {

				// If a shorter path to a vertex is
				// found than the currently stored
				// distance replace it in the Q
				it = Q.iterator();
				while (it.hasNext()) {
					Map.Entry<Integer, Integer> entry
						= it.next();
					if (entry.getValue() == v) {
						Q.remove(entry);
						break;
					}
				}
				dist[v] = dist[s] + 1;
				near[v] = s;
				Q.add(Map.entry(dist[v], v));
			}
		}

		// Stop when the Q is empty -> All
		// vertices have been visited. And we only
		// visit a vertex when we are sure that a
		// shorter path to that vertex is not
		// possible
		if (Q.size() == 0)
			return;

		// Go to the first vertex in Q
		// and remove it from the Q
		int next = Q.iterator().next().getValue();
		Q.remove(Map.entry(dist[next], next));

		multiSourceBFSUtil(graph, next);
	}

	// This function calculates the distance of
	// each vertex from nearest source
	// static void multiSourceBFS(List<Integer>[] graph, int
	// n, int[] sources) {
	// // Initialize the dist array with MAX_VALUE
	// dist = new int[n + 1];
	// Arrays.fill(dist, Integer.MAX_VALUE);

	// // Set the distance of the sources to 0
	// for (int i = 0; i < sources.length; i++) {
	//	 dist[sources[i]] = 0;
	// }

	// for (int i = 1; i <= n; i++) {
	//	 Q.add(Map.entry(dist[i], i));
	// }
	static void multiSourceBFS(List<Integer>[] graph, int n,
							int[] sources)
	{
		// Initialize the dist array with n
		dist = new int[n + 1];
		Arrays.fill(dist, n);
		near = new int[n + 1];
		Arrays.fill(near, 0);

		// Set the distance of the sources to 0
		for (int i = 0; i < sources.length; i++) {
			dist[sources[i]] = 0;
		}

		for (int i = 1; i <= n; i++) {
			Q.add(Map.entry(dist[i], i));
		}
		// rest of the code is same
		//...

		// Get the vertex with lowest distance,
		int start = Q.iterator().next().getValue();

		multiSourceBFSUtil(graph, start);

		// Printing the distances
		for (int i = 1; i <= n; i++)
			System.out.println(i + " " + near[i]);
	}

	static void addEdge(List<Integer>[] graph, int u, int v)
	{
		graph[u].add(v);
		graph[v].add(u);
	}

	// Driver Code
	public static void main(String[] args)
	{
		// Number of vertices
		int n = 6;

		List<Integer>[] graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// Edges
		addEdge(graph, 1, 2);
		//addEdge(graph, 1, 6);
		addEdge(graph, 2, 6);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 6);
		addEdge(graph, 5, 4);
		//addEdge(graph, 6, 5);
		addEdge(graph, 3, 4);
		addEdge(graph, 5, 3);

		// Sources
		int[] sources = { 1, 5 };

		multiSourceBFS(graph, n, sources);
	}
} // this code is contributed by devendra

package com.crio.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Node {
    int r;
    int c;
    int time;

    public Node(int r,int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

public class RottingOrange {
	
	public static int rottingOranges(List<List<Integer>> grid) {

		Queue<Node> q = new ArrayDeque<>();
		int r = grid.size();
		int c = grid.get(0).size(); // Assuming all rows have the same number of columns

		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {

				if (grid.get(i).get(j) == 2) {
					q.add(new Node(i, j, 0));
				}

			}
		}

		int maxTime = 0;

		int[] dr = { -1, 0, +1, 0 };
		int[] dc = { 0, +1, 0, -1 };

		while (q.size() != 0) {
			Node curr = q.remove();

			for (int idx = 0; idx < 4; idx++) {
				int i = curr.r + dr[idx];
				int j = curr.c + dc[idx];

				if (i < 0 || j < 0 || i >= r || j >= c)
					continue;

				// System.out.println( i +" " + j + " " + grid.get(i).set(j,2));
				if (grid.get(i).get(j) == 1) {
					// int i = arrlist.set(3, 30);
					grid.get(i).set(j, 2);
					//System.out.println(i + " " + j + " " + grid.get(i).set(j, 2));
					q.add(new Node(i, j, curr.time + 1));
					maxTime = Math.max(maxTime, curr.time + 1);

				}

			}
		}

			for (int i = 0; i < r; i++) {

				for (int j = 0; j < c; j++) {

					if (grid.get(i).get(j) == 1) {
						return -1;
					}

				}
			}

			//return maxTime;
		
		return maxTime;
	}
	 
	 		
	       // return maxTime
	
	public static void main(String[] args) {
		// Example input: list of edges represented as list of lists
		List<List<Integer>> list = new ArrayList<>();
		
		list.add(Arrays.asList(2,1 ,1));
		list.add(Arrays.asList(1 ,1, 0));
		list.add(Arrays.asList(0 ,1 ,2));
		List<List<Integer>> edges = new ArrayList<>(list); 
		int nodes = 0;
		for (List<Integer> edge : edges) {
			nodes = Math.max(nodes, edge.get(0));
			nodes = Math.max(nodes, edge.get(1));
		}
		//MaxAreaOfIsland pathFinder = new MaxAreaOfIsland();

		int result = rottingOranges(edges);
		System.out.println(result);

	}

}

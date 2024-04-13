package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	public static void main(String[] args) {

		int grid[][] = { { 2, 4, 7 }, {  8 }, { 2,5,5,9 } };

		ArrayList<ArrayList<Integer>> Matrix = new ArrayList<>();;
		for (int i = 0; i < grid.length; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < grid[i].length; j++) {
				row.add(grid[i][j]);
			}
			Matrix.add(row);
			System.out.println("row" + row);
		}

		ArrayList<Integer> check = mergeKSortedArrays(Matrix);
		for (int i = 0; i < check.size(); i++) {
			
			System.out.println( check.get(i));
		}

	}
	
	static class Node
	{
		int val;
		int row;
		int col;
		
		Node(int val,int row, int col)
		{
			this.val =val;
			this.row=row;
			this.col=col;
		}
	}
	
	 static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arrays){
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	      
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {

				if (a.val < b.val)
					return -1;
				else if (a.val > b.val)
					return 1;
				else
					return 0;
			});
			
			for(int i =0;i< arrays.size();i++)
			{
				if (arrays.get(i).size() ==0)
					continue;
				pq.add(new Node(arrays.get(i).get(0),i,0));
			}
			
			
			while (pq.size() != 0) {
				Node node = pq.remove();
				ans.add(node.val);
				node.col++;
				if (arrays.get(node.row).size() > node.col) {
					node.val = arrays.get(node.row).get(node.col);
					pq.add(node);
				}
			}
	        return ans;
	    }


}

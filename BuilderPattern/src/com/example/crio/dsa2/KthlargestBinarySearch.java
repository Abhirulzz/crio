package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.List;

public class KthlargestBinarySearch {

	public static void main(String[] args) {

		int grid[][] = { { 1, 5, 9 }, { 10, 11, 8 }, { 12, 13, 15 } };

		List<List<Integer>> Matrix = new ArrayList<>();;
		for (int i = 0; i < grid.length; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < grid[0].length; j++) {
				row.add(grid[i][j]);
			}
			Matrix.add(row);
			System.out.println("row" + row);
		}

		int check = kthSmallestElementInMatrix(Matrix, 8);
		System.out.println("isMagicSquare " + check);

	}

	public static int countLessEqual(List<List<Integer>> matrix, int mid) {
		int count = 0;
		int rows = matrix.size();
		int cols = matrix.get(0).size();
		int row = rows - 1;
		int col = 0;
		
		while (row >= 0 && col < cols) {
			if (matrix.get(row).get(col) >= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

		
		return count;
	}

	static int kthSmallestElementInMatrix(List<List<Integer>> matrix, int k) {
		int rows = matrix.size();
		int cols = matrix.get(0).size();
		int low = matrix.get(0).get(0);
		int high = matrix.get(rows - 1).get(cols - 1);
		
		while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

	/*	while (low < high) {
			int mid = low + (high - low) / 2;
			int count = countGreaterEqual(matrix, mid);

			if (count < k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		} */

		return low ;

	}

}

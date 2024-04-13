package com.example.crio.dsa4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPlatform {

	static class Train {
		int start;
		int end;

		Train(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String args[]) {
		int starting[] = { 1, 2, 3 };
		int ending[] = { 2, 3, 4 };

		System.out.println(minimumPlatforms(starting.length, starting, ending));
	}

	static int minimumPlatforms(int n, int arrival[], int departure[]) {

		int minimumPlatform = 0;

		Train arr[] = new Train[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Train(arrival[i], departure[i]);
		}

		Arrays.sort(arr, (c, b) -> Integer.compare(c.start, b.start));

		PriorityQueue<Integer> minheap = new PriorityQueue<>((endTime1, endTime2) -> {

			return Integer.compare(endTime1, endTime2);
		});

		minheap.add(arr[0].end);

		// [5,10][5,15]

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].start > minheap.peek()) {
				minheap.poll();
			}
			minheap.add(arr[i].end);

		}

		return minheap.size();
	}
}

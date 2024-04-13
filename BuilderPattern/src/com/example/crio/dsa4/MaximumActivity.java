package com.example.crio.dsa4;

import java.util.PriorityQueue;

public class MaximumActivity {

	static int activitySelection(int n, int starting[], int ending[]) {
		int maximumActivity = 0;
		PriorityQueue<Activity> pq = new PriorityQueue<>((activity1, activity2) -> {

			if (activity1.end < activity2.end)
				return -1;
			else if (activity1.end > activity2.end)
				return 1;
			else
				return 0;
		});

		for (int i = 0; i < n; i++)
			pq.add(new Activity(starting[i], ending[i]));
		int lastEndTime = -1;
		while (pq.size() != 0) {
			
			Activity currentActivity = pq.poll();
			System.out.println(currentActivity.toString());
			if (currentActivity.start >= lastEndTime) {
				maximumActivity++;
				lastEndTime = currentActivity.end;
			}
		}

		return maximumActivity;

	}

	static class Activity {
		int start;
		int end;

		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Activity [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String args[]) {
		int starting[] = { 6,2,8,2,10,1,9,3,5,7 };
		int ending[] = { 7,5,9,3,11,2,10,4,6,8 };

		System.out.println(activitySelection(starting.length, starting, ending));
	}

}

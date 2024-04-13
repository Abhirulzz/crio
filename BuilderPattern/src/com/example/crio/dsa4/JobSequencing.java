package com.example.crio.dsa4;

import java.util.Arrays;

public class JobSequencing {
	
	
	static class Job implements Comparable<Job> {
	   
	    int deadline;
	    int profit;

	    public Job( int deadline, int profit) {
	        
	        this.deadline = deadline;
	        this.profit = profit;
	    }

	    @Override
	    public int compareTo(Job other) {
	        return other.profit - this.profit; // Sort by profit in descending order
	    }
	}

	static int jobSequencing(int n, int deadlines[], int profits[]) {
		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(deadlines[i],profits[i]);
					}
		 Arrays.sort(jobs); // Sort jobs based on profit
		int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().orElse(0);
		int[] result = new int[maxDeadline + 1];
		Arrays.fill(result, -1);

		int totalProfit = 0;
		for (Job job : jobs) {
			int deadline = job.deadline;
			while (deadline > 0 && result[deadline] != -1) {
				deadline--;
			}
			if (deadline > 0) {
				result[deadline] = job.deadline; // Place job in the slot
				totalProfit += job.profit;
			}
		}

		return totalProfit;
	}

	    public static void main(String[] args) {
	    	int deadlines[] = { 4,1,1,1 };
			int profits[] = { 20,10,40,30 };

			System.out.println(jobSequencing(deadlines.length, deadlines, profits));
	    }
	}




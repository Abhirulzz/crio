package com.example.crio.dsa4;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProfitTicket {


	// Function to return the maximized profit 
	static int maxProfit(int seats[], int k, int b) 
	{ 
		
		PriorityQueue<Integer> pq;
		pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int value : seats) 
		pq.add(value); 

		// To store the maximized profit 
		int profit = 0; 

		// To count the people that 
		// have been sold a ticket 
		int c = 0; 
		while (c < b)
		{ 

			// Get the maximum number of 
			// vacant seats for any row 
			int top = pq.remove(); 

			// If there are no vacant seats 
			if (top == 0) 
				break; 

			// Update the profit 
			profit = profit + top; 

			// Push the updated status of the 
			// vacant seats in the current row 
			pq.add(top - 1); 

			// Update the count of persons 
			c++; 
		} 
		
		return profit; 
	} 
		
	// Driver Code
	public static void main(String args[])
	{
		int seats[] = { 2, 3, 4, 5, 1 }; 
		int k = seats.length;
		int n = 6;
		//5+4+4+3+3+3
		//22

		System.out.println(maxProfit(seats, k ,n));
	}
	}

	// This code is contributed by rutvik_56



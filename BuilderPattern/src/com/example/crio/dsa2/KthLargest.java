package com.example.crio.dsa2;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

	
	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int h = 2;

		int result = findKthLargest(piles, h);
		System.out.println(result);
	}
	
	 public static int findKthLargest(int[] nums, int k) {
		 
		  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int val : nums)
			{
				pq.add(val);
			}
			int count =0;
			int max =0;
			
			while(count < k)
			{
			max = pq.remove();
			count ++;	
			}
	        
	        return max;
	    }
}

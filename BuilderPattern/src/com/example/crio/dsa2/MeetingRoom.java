package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class MeetingRoom {
	
	public static void main(String[] args)
	{
		int interval[][] = new int[][] { {0,20},{5,10},{10,15}
				};
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(interval));
		
		int n =findNumRooms(interval);

		System.out.println("reduce array");
		System.out.println(n);
	}
	
	 static int findNumRooms(int[][] arr) {
		 
		 List<Integer> a=new ArrayList<>();
		 	
	        Arrays.sort(arr, (c, b) -> Integer.compare(c[0], b[0]));
	        
	        PriorityQueue<Integer> minheap = new PriorityQueue<>((endTime1, endTime2) -> {
	           
	            return Integer.compare(endTime1, endTime2);
	        });
	        
	        minheap.add(arr[0][1]);
	        
	        //[5,10][5,15]
	     
	     for(int i=1;i<arr.length;i++)
			{
				if (arr[i][0] >= minheap.peek()) {
					minheap.poll();
				}
				minheap.add(arr[i][1]);

			}
	    	  
	         
	     return minheap.size();
	    }
}

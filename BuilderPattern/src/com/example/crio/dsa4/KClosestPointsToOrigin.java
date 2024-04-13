package com.example.crio.dsa4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	
	public static void main(String[] args)
	{
		long interval[][] = new long[][] { {0,20},{5,10},{10,15}
				};
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(interval));
		
		long[][] n =kClosestPointsToOrigin(interval,3);

		System.out.println("reduce array");
		System.out.println(Arrays.toString(n));
	}
	
	 public static long[][] kClosestPointsToOrigin(long[][] points, int k) {
		   
	        PriorityQueue<long[]> minheap = new PriorityQueue<>((a, b) -> {
	            long dist1 = (a[0] * a[0]) + (a[1] * a[1]);
	            long dist2 = (b[0] * b[0]) + (b[1] * b[1]);
	            return Long.compare(dist1, dist2);
	        });
	        
	        for(long[] val : points)
	        {
	        	minheap.add(val);
	        }
	        
	       
	        long[][] result = new long[k][2];
			for (int i = 0; i < k; i++) {
				result[i] = minheap.remove();
			}    
	        
	        return result;
	        
	        
	    }
}

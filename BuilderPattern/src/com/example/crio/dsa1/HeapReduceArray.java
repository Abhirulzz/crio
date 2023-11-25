package com.example.crio.dsa1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapReduceArray {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int n =reduceArray(5,arr);

		System.out.println("reduce array");
		System.out.println(n);
	}
	
	static int reduceArray(int n, int a[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int val : a)
		{
			pq.add(val);
		}
		
		while(pq.size() > 1)
		{
			int max = pq.remove();
			int secondMax =pq.remove();
			
			pq.add(max-secondMax);
		}
		
		if (pq.size() == 1)
		return pq.peek();
		else
		return 0;
    }

}

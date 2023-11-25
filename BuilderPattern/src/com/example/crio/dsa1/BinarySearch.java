package com.example.crio.dsa1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BinarySearch {
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int res = searchTarget(arr.length,arr,4);

		System.out.println("searched index");
		System.out.println(res);
	}
	
	 static int searchTarget(int N,int A[],int X){
	    
		int left =0;
		int right= N-1;
				
		while(left<= right)
		{
			int mid = (left+right)/2;
			if (A[mid]== X)
			{
				return mid;
			}
			else if (A[mid] < X)
			{
				left ++;
			}else if (A[mid] > X)
			{
				right--;
			}
		}
		return -1;
    }

}

package com.example.crio.dsa2;

import java.util.Arrays;

public class Kandane {
	
	
	public static  long contigiousSequence(int arr[] , int n) {
		
		int max=Integer.MIN_VALUE,maxEnding =0 ;
		
		for(int a :arr)
		{
			maxEnding = maxEnding+a;
			if (max <  maxEnding)
			
			max = maxEnding;
			
			if (maxEnding < 0)
				maxEnding =0;
		}
		
		
		return max;

	}
	public static  void kandane(int arr[]) {
	int maxSum = arr[0];
	int currentSum = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    currentSum = Math.max(arr[i], currentSum + arr[i]);
	    maxSum = Math.max(maxSum, currentSum);
	}
	System.out.println(maxSum);
	}
	
	public static void main(String[] args)
	{
		//int arr[] = new int[] {  -2, -3, 4, -1, -2, 1, 5, -3};
		int[] arr = {2, -3, 4, 1, -2, 1, 5, -3};
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		//long kandane =contigiousSequence(arr,arr.length);
		kandane(arr);

		System.out.println("Kandane is");
		//System.out.println(kandane);
	}

}

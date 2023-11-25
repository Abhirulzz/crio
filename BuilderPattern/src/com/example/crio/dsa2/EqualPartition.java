package com.example.crio.dsa2;

import java.util.Arrays;

public class EqualPartition {
	
	public static void main(String[] args)
	{
		//long arr[] = new long[] { 60, 43, 51, 47, 89, 86, 53, 93, 49, 92, 66, 85, 35, 36, 33, 33, 23, 67, 41, 50, 18, 63, 53, 41, 74 ,833 };
		System.out.println("Given Array is");
		long arr[] = new long[] {1,2,3};
		System.out.println(Arrays.toString(arr));
		
		int centerElement = equalPartition(arr.length,arr);

		System.out.println("Rotated Array is");
		System.out.println(centerElement);
	}
	
	static int equalPartition(int n, long arr[]) {
		long prefix[] = new long[n];
		long leftSum =0;
		for(int i=0;i<n;i++)
		{
			prefix[i] = leftSum+arr[i];
			leftSum = prefix[i];
		}
		
		System.out.println("prefix Array is");
		System.out.println(Arrays.toString(prefix));
		
		long rightSum =0;
		for(int i=0;i<n;i++)
		{
			rightSum = prefix[n-1]-prefix[n-1-i];
			System.out.println("rightSum" + rightSum);
			if(n-1-i!= 0 && rightSum == prefix[n-i-2])
			{
				return n-i-1;
			}
		}
		
		return -1;
    }

}

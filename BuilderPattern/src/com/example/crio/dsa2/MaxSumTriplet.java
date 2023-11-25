package com.example.crio.dsa2;

import java.util.Arrays;

public class MaxSumTriplet {
	
	 static long maxSumTriplet(int n, long arr[]) {
		 long ans=0;
		 
		 for(int i =1;i<n-1;i++)
		 {
			 long max1 =0,max2=0;
			 for(int j =0; j<i;j++)
			 {
				 if (arr[j] < arr[i])
					 max1 =Math.max(max1, arr[j]);

			 }
			 for(int k=i+1;k <n ; k++)
			 {
				 if (arr[k] > arr[i])
					 max2 =Math.max(max2, arr[k]);
				 
			 }
			 
			 if(max1 > 0 && max2 > 0)
			 {
				 ans = Math.max(ans, max1+ arr[i]+max2);
			 }
		 }
		 
		 return ans;
	    }
	
	
	
	public static void main(String[] args)
	{
		long arr[] = new long[] { 3, 7, 4, 2, 5, 7, 5 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		long tripletSum =maxSumTriplet(arr.length,arr);

		System.out.println("Rotated Array is");
		System.out.println(tripletSum);
	}

}

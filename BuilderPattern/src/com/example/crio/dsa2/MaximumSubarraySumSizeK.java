package com.example.crio.dsa2;

import java.util.Arrays;

public class MaximumSubarraySumSizeK {
	
	static int maximumSubarraySumSizeK(int[] arr, int n, int k) {
		
		int maxSum=0;
		int ksum =0;
		
		for(int i=0;i<k;i++)
		{
			ksum = ksum+arr[i];
			maxSum=ksum;
		}
		
		for(int i=k;i<n;i++)
		{ 
			ksum = ksum+arr[i]-arr[i-k];
			
			if (ksum > maxSum)
			{
				//ksum = ksum+arr[i]-arr[i-k];
				maxSum= ksum;
			}
		}
		
		return maxSum;
    }
	
	public static void main(String[] args) {
		System.out.println("Given Array is");
		String input ="807 249 73 658 930 272 544 878 923 709 440 165 492 42 987 503 327 729 840 612 303 169 709 157 560 933 99 278 816 335 97 826 512 267 810 633 979 149 579 821 967 672 393 336 485 745 228 91 194 357 1 153 708";
		String[] inputArray = input.split(" ");
		  int[] arr = new int[inputArray.length];
		   for (int i = 0; i < inputArray.length; i++) {
		      arr[i] = Integer.parseInt(inputArray[i]);
		   }
		
		//int arr[] = new int[] { 100, 200, 300, 400};
		System.out.println(Arrays.toString(arr));
		int k =52;
		int centerElement = maximumSubarraySumSizeK(arr ,arr.length,k);

		System.out.println("maximumSubarraySumSizeK is");
		System.out.println(centerElement);
	}

}

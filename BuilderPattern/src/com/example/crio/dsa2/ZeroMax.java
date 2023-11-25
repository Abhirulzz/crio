package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class ZeroMax {

	public static String subarraySumZero(Vector<Integer> arr) {

		HashSet<Integer> prefixSum = new HashSet<Integer>();
		int sum = 0;

		for (int i = 0; i < arr.size(); i++) {
			sum = sum + arr.get(i);
			if (arr.get(i) == 0 || sum == 0 || prefixSum.contains(sum))
				return "Yes";
			prefixSum.add(sum);

		}

		return "No";
	}

	static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {
		
		ArrayList<Integer>  subarray = new ArrayList<Integer>();
		HashMap<Integer,Integer> maxLengthMap = new HashMap<Integer,Integer>();
		int maxLength =0;
		int prefixSum[] = new int[n];
		int leftSum =0;
		int startIndex =0;
		int endIndex =0;
		for (int i =0;i <n; i++)
		{
			prefixSum[i] = leftSum + arr[i];
			leftSum = prefixSum[i];
			System.out.println(i +" leftSum " + leftSum +" " + arr[i]) ;
			
			/*if( arr[i] == 0 )
			{
					maxLength = 1 ; 
					startIndex= i;
					endIndex=i+1;
			}*/
			if( leftSum == 0 )
			{
					//maxLength = i; 
				if((i - maxLengthMap.get(leftSum)) > maxLength)
				{
				maxLength =  i - maxLengthMap.get(leftSum);
				startIndex=maxLengthMap.get(leftSum) + 1;
				endIndex=i+1;
				}
					
			}
			
			if( maxLengthMap.containsKey(leftSum))
			{
					
					if((i - maxLengthMap.get(leftSum)) > maxLength)
					{
					maxLength =  i - maxLengthMap.get(leftSum);
					startIndex=maxLengthMap.get(leftSum) + 1;
					endIndex=i+1;
					}
					
			}else {
			maxLengthMap.put(leftSum, i);
			}
			
		}
		
		for (int i =startIndex;i <endIndex; i++)
		{
			subarray.add(arr[i]);
		
		}

		if (subarray.size() == 0)
			subarray.add(-1);
		
		return subarray;

	}

	public static void main(String[] args) {
		// long arr[] = new long[] { 60, 43, 51, 47, 89, 86, 53, 93, 49, 92, 66, 85, 35,
		// 36, 33, 33, 23, 67, 41, 50, 18, 63, 53, 41, 74 ,833 };
		System.out.println("Given Array is");
		//int arr[] = new int[] { 2, 8, -3,-5,2,-4,6,1,2,1,-3,4 };
		//int arr[] = new int[] {2, 3, 1, -4, 0, 6};
		int arr[] = new int[] {-1, -1, 0, -1, -1, -1};
		System.out.println(Arrays.toString(arr));

		// int centerElement = equalPartition(arr.length,arr);

		
		
		//String input ="-16 -14 12 -3 14 -19 11 7 11 1 20 -18 3 13 -9 -6 -10 -3 5 0 -13 13 -8 11 -10 20 -13 -14 4 9 15 7 -11 -3 -6 -4 -13 -9 4 16 -5 -20 15 8 7 -13 17 9 14 -12 -4 15 -10 -18 -16 16 -17 3 20 -11 7 5 4 18 -19 12 -15 -1 -6 15 18 20 5 12 -17 -13 -19 10 12 -5 -19 9 -3 10 -13 -15 -1 -3";
		String input = "8 20 -11 -4 -10 -7 13 2 17 -19 -4 0 4 15 10 10 1 2 3 -10 -18 -2 0 -12 17 6 -2 -1 5 -3 -9 16 2 7 -16 -18 0 2 -17 -2 4 -20 -19 -13 1 -14 15 -3 9 10 -17 10 -4 -10 10 17 19 15 17 -6 0 -5 -12 18 -19 -11 -17 4 -1 15 -9 6 -16 6 2 -15 15 -20 -11 6 -12 -7 11 -5 13 16 -16 -11 -15 19 -3 -16 -3 16 -19 -16 14 -5 -8 -18 12 7 10 -11 -18 -18 14 -10 -14 -15 -5 18 -1 -15 -12 15 3 -5 -5 -12 -6 20 -13 -5 18 9 -6 -19 13 14 2 -19 12 -6 16 13 12 7 -15 -5 10 8 16 10 -11 -17 -19 -17 -18 -14 5 -6 -15 0 18 4 -15 -1 -13 -15 -10 17 -20 3 8 -5 -4 12 19 9 -12 -11 3 18 -15 15 -1 20 3 -19 6 6 -20 -10 11 -14 -12 -9 -6 -18 -8 17 6 -18 -1 -4 10 9 2 14 9 4 5 15 17 -7 -7 -2 10 -9 4 14 -17 -3 -15 -20 -12 -18 -9 -4 -9 10 0 -5 19 -5 12 0 -10 15 -2 -3 16 -1 12 13 -1 -19 5 16 17 -17 -14 -20 -19 15 -2 -4 0 5 6 18 -5 -15 10 6 -15 1 -9 16 -11 -15 15 -4 -3 8 -19 -11 -11 -8 -5 -2 12 -3 -12 7 -17 10 8 17 3 -18 3 -17 -6 11 0 -18 -16 -7 -15 5 -9 11 3 0 -1 16 13 -20 -10 -12 -8 -18 4 3 -13 14 1 -5 7 -3 -9 1 8 -13 9 13 5 -6 9 -11 -8 -8 -9 17 3 19 -11 -10 6 -9 -5 11 4 19 -20 4 -19 1 0 -15 -9 7 1 -17 14 1 -17 -20 -19 -5 7 3 -16 -14 12 -3 14 -19 11 7 11 1 20 -18 3 13 -9 -6 -10 -3 5 0 -13 13 -8 11 -10 20 -13 -14 4 9 15 7 -11 -3 -6 -4 -13 -9 4 16 -5 -20 15 8 7 -13 17 9 14 -12 -4 15 -10 -18 -16 16 -17 3 20 -11 7 5 4 18 -19 12 -15 -1 -6 15 18 20 5 12 -17 -13 -19 10 12 -5 -19 9 -3 10 -13 -15 -1 -3 6 -12 -2 -14 -6 -17 -20 16 -3 -14 1 1 5 16 -2 2 -10 11 -8 -16 -13 -7 -1 15 -7 -19 12 -3";
		String[] inputArray = input.split(" ");
		  int[] result = new int[inputArray.length];
		   for (int i = 0; i < inputArray.length; i++) {
		      result[i] = Integer.parseInt(inputArray[i]);
		   }
		System.out.println(" length " + inputArray.length);
		ArrayList<Integer> subarray = largestSubarraySumZero(result.length, result);

		System.out.println("Rotated Array is");
		
		for (int s : subarray) {
		System.out.println(s);
		}
	}

}

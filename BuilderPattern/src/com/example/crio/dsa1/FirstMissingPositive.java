package com.example.crio.dsa1;

import java.util.Arrays;

public class FirstMissingPositive {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 3 ,4 ,-1 ,1 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int n =firstMissingPositive(arr);

		System.out.println("reduce array");
		System.out.println(n);
	}
	
	static int firstMissingPositive(int[] nums) {

		boolean isPresent[]  = new boolean[nums.length];
		for(int i : nums)
		{
		
		if((i >= 0) && (i < nums.length))
		{
			isPresent[i] =true;
		}
		}
		
		for (int i = 1; i < nums.length; i++) {
			if (!isPresent[i]) {

				return i ;

			}
		}

		return nums.length+1;

	}


}

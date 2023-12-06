package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	
	public static  List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		//List<Integer> triplet = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					
				
				 while (j < k && nums[j] == nums[j + 1]) {
                     j++;
                 }

                 // Skip duplicate elements for k
                 while (j < k && nums[k] == nums[k - 1]) {
                     k--;
                 }

                 // Move the pointers
                 j++;
                 k--;
             } else if (sum < 0) {
                 // Sum is less than zero, increment j to increase the sum
                 j++;
             } else {
                 // Sum is greater than zero, decrement k to decrease the sum
                 k--;
             }
         }
     }
		return result;
	}
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { -1, 0, 1,2, 2, -1, -4 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		List<List<Integer>> tripletSum =threeSum(arr);

		System.out.println("Rotated Array is");
		System.out.println(tripletSum);
	}

}

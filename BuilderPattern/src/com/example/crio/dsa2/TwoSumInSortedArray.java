package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumInSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 4, 5, 9, 8 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));

		boolean isTwoSumInSortedArray = twoSumInSortedArray(arr.length, arr, 7);

		System.out.println("isTwoSumInSortedArray ");
		System.out.println(isTwoSumInSortedArray);

		int[] isTwoSumUnSortedArray = twoSum(arr, 7);

		System.out.println("Rotated Array is");
		System.out.println(Arrays.toString(isTwoSumUnSortedArray));
	}

	static boolean twoSumInSortedArray(int n, int arr[], int k) {

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (arr[i] + arr[j] > k && i != j)
				j--;
			if (arr[i] + arr[j] == k && i != j)
				return true;
			if (arr[i] + arr[j] < k && i != j)
				i++;
		}

		return false;
	}

	static int[] twoSum(int[] nums, int target) {

		
			HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
			int[] intArray = new int[2];

			for (int i = 0; i < nums.length; ++i) {

				s.put(nums[i], i);
			}

			for (int i = 0; i < nums.length; ++i) {
				int temp = target - nums[i];

				if (s.containsKey(temp) ) {
					System.out.println(s.get(temp));
					intArray[0] = i;
					intArray[1] = s.get(temp);
					break;
				}

			}
			return intArray;
		

	}
}

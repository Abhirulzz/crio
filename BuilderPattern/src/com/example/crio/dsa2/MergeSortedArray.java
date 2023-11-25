package com.example.crio.dsa2;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static int [] mergeSortedArray(int[] nums1,  int[] nums2) {
		int[] result = new int[nums1.length +nums2.length];
		int k=0;
		int i=0,j=0;
		
		while(i<nums1.length && j < nums2.length)
		{
			if(nums1[i] <= nums2[j])
			{
				result[k] = nums1[i];
				i++;
				k++;
			}
			else
			{
				result[k] =nums2[j];
				j++;
				k++;
			}
		}
		
		while(i<=(nums1.length -1))
		{
			result[k] = nums1[i];
			i++;
			k++;
		}
		
		while(j<=(nums2.length -1))
		{
			result[k] = nums2[j];
			j++;
			k++;
		}
		
		return result;
    }
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 1,2,3 };
		int arr2[] = new int[] { 2,5,6 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int[] merge= mergeSortedArray(arr,arr2);

		System.out.println("merge Array is");
		System.out.println(Arrays.toString(merge));
	}

}

package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaveFashion {
	static List<Integer> swap(List<Integer>nums, int i ,int j){
		 int temp = nums.get(i);
		 nums.set(i,nums.get(j));
		 nums.set(j, temp);
		
		return nums;
    }
	
	 static List<Integer> wiggleSort(int n, List<Integer>nums){
		 
		 
		 for(int i=0;i<nums.size()-1;i++)
		 {
			 int current = nums.get(i);
			 int next = nums.get(i+1);
			 			 
			 if(i%2 ==0 && current > next)
			 {
				 swap(nums,i,i+1);
			 }
			 
			 if(i%2 !=0 && current < next)
			 {
				 swap(nums,i,i+1);
			 }
		 }
		 
		 return nums;
		 
	    }
	 
	 public static void main(String[] args) {
			
			System.out.println("Given Array is");
			int arr[] = new int[] { 1, 5, 1, 1, 6, 4};
			
			System.out.println(Arrays.toString(arr));
			
			List<Integer>  subarray = new ArrayList<Integer>();
			
			 for (int i = 0; i < arr.length; i++) {
			      subarray.add(arr[i]);
			   }

			
			List<Integer> result=wiggleSort(subarray.size(), subarray);

			System.out.println("Rotated Array is");
			
			for (int s : result) {
			System.out.println(s);
			}
		}
	 
	 
}

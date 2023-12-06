package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKsum {
	
	static int maximumSubarraySumSizeK(int[] arr, int n, int k) {
		 HashMap<Integer, Integer> map = new HashMap<>();
         int sum = 0, maxLen = 0;

         // traverse the given array
         for (int i = 0; i < n; i++) {
             
              // accumulate sum
              sum += arr[i];
             
              // when subarray starts from index '0'
              if (sum == k)
                  maxLen = i + 1;

              // make an entry for 'sum' if it is
              // not present in 'map'
              if (!map.containsKey(sum)) {
                  map.put(sum, i);
              }

              // check if 'sum-k' is present in 'map'
              // or not
              if (map.containsKey(sum - k)) {
                   
                  // update maxLength
                  if (maxLen < (i - map.get(sum - k)))
                      maxLen = i - map.get(sum - k);
              }
         }
          
         return maxLen;  
	}
	
	public static void main(String[] args) {
		System.out.println("Given Array is");
		//String input ="807 249 73 658 930 272 544 878 923 709 440 165 492 42 987 503 327 729 840 612 303 169 709 157 560 933 99 278 816 335 97 826 512 267 810 633 979 149 579 821 967 672 393 336 485 745 228 91 194 357 1 153 708";
		String input ="-5 8 -14 2 4 12";
		String[] inputArray = input.split(" ");
		  int[] arr = new int[inputArray.length];
		   for (int i = 0; i < inputArray.length; i++) {
		      arr[i] = Integer.parseInt(inputArray[i]);
		   }
		
		//int arr[] = new int[] { 100, 200, 300, 400};
		System.out.println(Arrays.toString(arr));
		int k =-5;
		int centerElement = maximumSubarraySumSizeK(arr ,arr.length,k);

		System.out.println("maximumSubarraySumSizeK is");
		System.out.println(centerElement);
	}

}

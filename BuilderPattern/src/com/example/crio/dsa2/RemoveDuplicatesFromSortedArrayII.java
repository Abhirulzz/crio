package com.example.crio.dsa2;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 8,8,8 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int newLength =removeDuplicatesFromSortedArrayII(arr.length,arr);

		System.out.println("Rotated Array is " + newLength);
		System.out.println(Arrays.toString(arr));
	}

	
	 static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
		 int st = 0;
		 
		    // Iterate over the array
		    for (int i = 0; i < n; i++) {
		 
		        if (i < n - 2
		            && arr[i] == arr[i + 1]
		            && arr[i] == arr[i + 2])
		            continue;
		 
		        // Updating the 2nd pointer
		        else {
		            arr[st] = arr[i];
		            st++;
		        }
		    }
		    
		   /* while(st<(n))
			{
		    	arr[st] = 0;
				st++;
			} */
		 return st;
	    }
}

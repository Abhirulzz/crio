package com.example.crio.dsa1;

import java.util.Arrays;

public class mergesort {


	// Merge two subarrays arr[l..m] and arr[m+1..r] 
	static void merge(String arr[], int l, int m, int r) 
	{ 
		int i, j, k; 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* create temp arrays */
		String L[] = new String[n1], R[] = new String[n2]; 

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++) 
		L[i] = arr[l + i]; 

		for (j = 0; j < n2; j++) 
		R[j] = arr[m + 1+ j]; 

		/* Merge the temp arrays back into arr[l..r]*/
		i = 0; // Initial index of first subarray 
		j = 0; // Initial index of second subarray 
		k = l; // Initial index of merged subarray 
		while (i < n1 && j < n2) 
		{ 
		if (L[i].compareTo(R[j])<=0) 
		{ 
			arr[k] = L[i]; 
			i++; 
		} 
		else
		{ 
			arr[k] = R[j]; 
			j++; 
		} 
		k++; 
		} 

		/* Copy the remaining elements of L[], if there 
		are any */
		while (i < n1) 
		{ 
		arr[k] = L[i]; 
		i++; 
		k++; 
		} 

		/* Copy the remaining elements of R[], if there 
		are any */
		while (j < n2) 
		{ 
		arr[k] = R[j]; 
		j++; 
		k++; 
		} 
	} 

	/* l is for left index and r is right index of the 
	sub-array of arr to be sorted */
	static void mergeSort(String arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
		// Same as (l+r)/2, but avoids overflow for 
		// large l and h 
		int m = l+(r-l)/2; 

		// Sort first and second halves 
		mergeSort(arr, l, m); 
		mergeSort(arr, m+1, r); 

		merge(arr, l, m, r); 
		} 
	} 

	/* UTILITY FUNCTIONS */
	/* Function to print an array */
	static void printArray(String A[], int size) 
	{ 
		int i; 
		for (i=0; i < size; i++) 
		System.out.print(A[i] + " "); 
		System.out.println();
		Arrays.sort(A);
	} 


	public static void main (String[] args) {
		String arr[] = {"batman", "bat", "apple"}; 
		int arr_size = arr.length;

		System.out.println("Given array is"); 
		printArray(arr, arr_size); 

		mergeSort(arr, 0, arr_size - 1); 

		System.out.println("\nSorted array is"); 
		printArray(arr, arr_size); 
	}
	}

	// This code is contributed by aadityaburujwale.




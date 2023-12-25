package com.example.crio.dsa1;

public class BitManipulation {
	
	

	    public static int findDuplicate(int[] arr) {
	        int n = arr.length;
	        int xorResult = 0;

	        // XOR all elements in the array
	        for (int i = 0; i < n; i++) {
	            xorResult ^= arr[i];
	            System.out.println(xorResult);
	        }

	        // XOR with all numbers from 1 to n-1
	        for (int i = 1; i < n; i++) {
	            xorResult ^= i;
	            System.out.println("xorResult1" + xorResult);
	        }

	        return xorResult;
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 3};
	        int duplicate = findDuplicate(arr);
	        System.out.println("Duplicate element: " + duplicate);
	    }
	}




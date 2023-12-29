package com.example.crio.dsa2;

import java.util.Arrays;

public class MissingNumberFinder {


	    public static int findMissingNumber(int[] sortedArray) {
	        int left = 0;
	        int right = sortedArray.length - 1;
	        int pos = sortedArray.length - 1;;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            // Adjust the expected value based on the starting point
	            int expectedValue = sortedArray[0] + mid;

	            // Check if the missing number is on the left or right side
	            if (sortedArray[mid] != expectedValue) {
	                // Missing number is on the left side
	                right = mid - 1;
	                pos=expectedValue;
	            } else {
	                // Missing number is on the right side
	                left = mid + 1;
	                pos=expectedValue+1;
	            }
	        }

	        // The missing number is at 'sortedArray[left] + 1'
	        return pos;
	    }

	    public static void main(String[] args) {
	        int[] sortedArray = {5, 6, 7, 8,9,11, 12};
	        int missingNumber = findMissingNumber(sortedArray);
	        System.out.println("The missing number is: " + missingNumber);
	    }
	

}

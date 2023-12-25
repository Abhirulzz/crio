package com.example.crio.dsa2;

import java.util.Arrays;

public class BinarySearch {
	
	
	public static void main(String[] args) {
		System.out.println("Given Array is");
		
		String input="986 211 197 512 882 169 143 67 38 641 573 944 300 500 722 331 821 637 261 977 522 894 111 780 251 410 602 592 572 586 378 733 252 668 547 590 140 368 389 250 934 5 658 479 19 245 33 286 665 968 307 215 209 191 454 803 865 41 963 132 503 490 893 195 458 587 427 860 973 804 456 544 300 617 123 688 181 865 627 127 349 550 779 631 652 404 486 170 606 579 15 81 708 529 248 81 102 49 256 119";
		String[] inputArray = input.split(" ");
		  int[] arr = new int[inputArray.length];
		   for (int i = 0; i < inputArray.length; i++) {
		      arr[i] = Integer.parseInt(inputArray[i]);
		   }
		int arr1[] = new int[] { -1, 2, 2, 4, 7};
		System.out.println(Arrays.toString(arr1));
		int key =2;
		int index = countOccurrences(arr1.length,key,arr1);
		//int peak = findPeakElement(arr1);
		
       

		System.out.println("ContainerWithMostWater is");
		System.out.println(index);
	}
	
	public static int search(int[] arr, int key) {
		int pivot = findPivot1(arr);
		

        // If there is no pivot, the array is not rotated
        if (pivot == -1) {
            return binarySearch(arr, 0, arr.length - 1, key);
        }

        // If the pivot is found, perform binary search in the appropriate subarray
        if (arr[pivot] == key) {
            return pivot;
        }
        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot - 1, key);
        }
        return binarySearch(arr, pivot + 1, arr.length - 1, key);
		//int centerElement = findFirst(arr);
    }
	
	public static int findFirst(int[] arr) {
		int result = -1;
			//int prefix[] = new int[height.length];
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r)  / 2;

            if (arr[mid] == 1) {
                // Update result and continue searching in the left subarray
                result = mid;
                r = mid - 1;
            } else  {
                // If target is greater, search in the right subarray
                l = mid + 1;
            }
		}

		return result;
	}
	
	public static int binarySearch(int[] arr,int l,int r,int key) {
		int result = -1;
		
		while (l <= r) {
			int mid = (l + r)  / 2;
			
			if (arr[mid] == key) {
			return mid;
			}

            if (arr[mid] >= key) {
                // Update result and continue searching in the left subarray
               
                r = mid - 1;
            } else  {
                // If target is greater, search in the right subarray
                l = mid + 1;
            }
		}

		return result;
	}
	
	public static int findPivot(int[] arr) {
		int result = -1;
			//int prefix[] = new int[height.length];
		int l = 1;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = l +r / 2;

            if (arr[mid-1] > arr[mid]) {
                // Update result and continue searching in the left subarray
                //result = mid;
                return mid - 1;
            } else  {
                // If target is greater, search in the right subarray
                l = mid + 1;
            }
		}

		return result;
	}
	
	private static int findPivot1(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid + 1]) {
                return mid; // Pivot point found
            }
            if ( arr[mid] < arr[mid - 1]) {
                return mid - 1; // Pivot point found
            }

            if (arr[low] >= arr[mid]) {
                high = mid - 1; // Search in the left subarray
            } else {
                low = mid + 1; // Search in the right subarray
            }
        }

        return -1; // No rotation, the array is not rotated
    }

	
	 private static int findPivot(int[] arr, int low, int high) {
	        if (high < low) {
	            return -1; // No rotation, the array is not rotated
	        }
	        if (high == low) {
	            return low; // Only one element left
	        }

	        int mid = (low + high) / 2;
	        if (mid < high && arr[mid] > arr[mid + 1]) {
	            return mid; // Pivot point found
	        }
	        if (mid > low && arr[mid] < arr[mid - 1]) {
	            return mid - 1; // Pivot point found
	        }
	        if (arr[low] >= arr[mid]) {
	            return findPivot(arr, low, mid - 1); // Search in the left subarray
	        }
	        return findPivot(arr, mid + 1, high); // Search in the right subarray
	    }

	 
	 public static int findPeakElement(int[] nums) {
	        int low = 0;
	        int high = nums.length - 1;

	        while (low < high) {
	            int mid = low + (high - low) / 2;

	            // Check if mid is a peak
	            if (nums[mid] > nums[mid + 1]) {
	                high = mid;  // Potential peak is on the left side
	            } else {
	                low = mid + 1;  // Potential peak is on the right side
	            }
	        }

	        // 'low' is the index of the peak element
	        return nums[low];
	    }
	 
	 static int countOccurrences(int n, int k, int arr[]) {

		 int firstOccurrence = findFirstOccurrence(arr, k);

	        // If the target is not present in the array, return 0
	        if (firstOccurrence == -1) {
	            return 0;
	        }

	        int lastOccurrence = findLastOccurrence(arr, k);

	        // Calculate the count of occurrences
	        return lastOccurrence - firstOccurrence + 1;


}
	 
static int findFirstOccurrence(int arr[], int k) {

	int low = 0;
	int high = arr.length - 1;
	
	int result = -1;
	while (low <= high) {
		int mid = low + (high - low) / 2;
	if (arr[mid] == k) {
		result = mid;
		high = mid - 1;
	} else if (arr[mid] < k) {
		
		low = mid + 1;
	} 
	else
	{
		high = mid-1;
	}
	}
	System.out.println("first" + result);
	return result;
}

static int findLastOccurrence(int arr[], int k) {

	int low = 0;
	int high = arr.length - 1;
	
	int result = -1;
	while (low <= high) {
		int mid = low + (high - low) / 2;
	if (arr[mid] == k) {
		result = mid;
		low = mid + 1;
	} else if (arr[mid] < k) {
		
		low = mid + 1;
	} 
	else
	{
		high = mid-1;
	}
	}
	System.out.println("last" + result);
	return result;
}
	 
	 
}

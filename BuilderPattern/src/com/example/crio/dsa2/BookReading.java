package com.example.crio.dsa2;

import java.util.Arrays;

public class BookReading {
	public static void main(String[] args) {
		System.out.println("Given Array is");
		
		String input="986 211 197 512 882 169 143 67 38 641 573 944 300 500 722 331 821 637 261 977 522 894 111 780 251 410 602 592 572 586 378 733 252 668 547 590 140 368 389 250 934 5 658 479 19 245 33 286 665 968 307 215 209 191 454 803 865 41 963 132 503 490 893 195 458 587 427 860 973 804 456 544 300 617 123 688 181 865 627 127 349 550 779 631 652 404 486 170 606 579 15 81 708 529 248 81 102 49 256 119";
		String[] inputArray = input.split(" ");
		  int[] arr = new int[inputArray.length];
		   for (int i = 0; i < inputArray.length; i++) {
		      arr[i] = Integer.parseInt(inputArray[i]);
		   }
		int arr1[] = new int[] { 3, 6, 7, 11};
		System.out.println(Arrays.toString(arr1));
		int key =8;
		int index = bookReading(arr1.length,key,arr1);
		//int peak = findPeakElement(arr1);
		
       

		System.out.println("ContainerWithMostWater is");
		System.out.println(index);
	}
	
	static int bookReading(int n,int h,int arr[]){
		int len =0;
		for(int a : arr)
			len =len +a;
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
	
	static int findTotalBooks(int n,int h,int arr[]){
		int len =0;
		for(int a : arr)
			len =len +a;
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
}

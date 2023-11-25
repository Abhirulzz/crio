package com.example.crio.dsa1;

import java.util.Arrays;

public class CyclicRotation {
	
		
		static void reverse(int arr[],int i,int j)
		{
			//int i = 0, j = arr.length - 1;
			while (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		static void rotate(int arr[],int k)
		{
			reverse(arr,0,(arr.length -k -1));
			reverse(arr,arr.length -k,arr.length - 1);
			reverse(arr,0,arr.length - 1);
		}

		/* Driver program */
		public static void main(String[] args)
		{
			int arr[] = new int[] { 1, 2, 3, 4, 5 };
			System.out.println("Given Array is");
			System.out.println(Arrays.toString(arr));
			
			rotate(arr,3);

			System.out.println("Rotated Array is");
			System.out.println(Arrays.toString(arr));
		}
	}




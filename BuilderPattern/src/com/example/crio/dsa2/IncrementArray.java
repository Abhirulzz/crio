package com.example.crio.dsa2;

import java.util.Arrays;

public class IncrementArray {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 8,8 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		incrementNumber(arr.length,arr);

		System.out.println("Rotated Array is");
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] incrementNumber(int n, int arr[]){
		
        for(int i= n-1;i>=0;i--)
        {
            if (arr[i] < 9)
            {
                arr[i]++;
                return arr;
            }else
            {
            	arr[i]=0;
            }
        }
        
        int result[] = new int[n+1];
        result[0] =1;
        
        return result;
    }

}

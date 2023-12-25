package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.Comparator;

public class AbsoluteValue {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 1,-2,4,2,-4,5 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		AbsoluteValue s = new AbsoluteValue();
		int[] sortAbsolute =s.sortArrayAbsolute(arr.length,arr);

		System.out.println(Arrays.toString(sortAbsolute));
	}
	
	
	public class CustomComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if (Math.abs(o1) < Math.abs(o2))
			return -1;
			else if  (Math.abs(o1) > Math.abs(o2))
			return 1;
			else if (Math.abs(o1) == Math.abs(o2))
			return 0;
			
			return 0;
		}
		
	}
	
	 int[] sortArrayAbsolute(int n, int arr[]) {
		
		Integer sort[] = new Integer[n];
		
		for(int i=0;i<n;i++)
		{
			sort[i] = arr[i];
		}
		
		Arrays.sort(sort, new CustomComparator());
		for(int i=0;i<n;i++)
		{
			arr[i] = sort[i];
		}
		
		return arr;
    }

}

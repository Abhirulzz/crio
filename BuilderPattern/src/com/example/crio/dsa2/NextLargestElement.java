package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElement {
	
	public static void main(String[] args)
	{
		int arr[] = new int[] { 6,3 ,4 ,2 ,5 };
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		int result[] =nextSmallestElement2(arr,arr.length);

		System.out.println("reduce array");
		System.out.println(Arrays.toString(result));
	}
	
	static int [] nextLargerElement(int nums[], int n) {
		
		int size = (n*2) - 1, k = n - 1;
		Stack<Integer> stck = new Stack<Integer>();
		int[] ans = new int[n];
		Arrays.fill(ans, -1);

		while(size >= 0) {
			int idx = size%n;

			while(!stck.isEmpty() && stck.peek() <= nums[idx]) 
				stck.pop();

			if(size < n) {
				if(!stck.isEmpty() && stck.peek() > nums[idx])
					ans[k] = stck.peek();
				k--;
			}

			stck.push(nums[idx]);
			size--;
		}

		return ans;
	}
	
static int [] nextLargerElement2(int nums[], int n) {
		
		//int size = (n*2) - 1, 
			int	k = n - 1;
		Stack<Integer> stck = new Stack<Integer>();
		int[] ans = new int[n];
		n=n-1;
		Arrays.fill(ans, -1);

		while(n >=0) {
			//int idx = size%n;

			while(!stck.isEmpty() && stck.peek() <= nums[n]) 
				stck.pop();

			
				if(!stck.isEmpty() && stck.peek() > nums[n])
					ans[k] = stck.peek();
				k--;
			

			stck.push(nums[n]);
			n--;
		}

		return ans;
	}


static int [] nextSmallestElement2(int nums[], int n) {
	
	//int size = (n*2) - 1, 
		int	k = n - 1;
	Stack<Integer> stck = new Stack<Integer>();
	int[] ans = new int[n];
	n=n-1;
	Arrays.fill(ans, -1);
   //iterate from backwards
	while(n >=0) {
		//int idx = size%n;

		while(!stck.isEmpty() && stck.peek() >= nums[n]) 
		stck.pop();

		
			if(!stck.isEmpty() && stck.peek() < nums[n])
			{
				ans[k] = stck.peek();
			}
			k--;
		

		stck.push(nums[n]);
		n--;
	}

	return ans;
}
	
	
	
	
	
	
	
static int [] nextLargerElement1(int nums[], int n) {
		
		int size = (n*2) - 1, k = n - 1;
		Stack<Integer> stck = new Stack<Integer>();
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		
		for(int i=0;i<n;i++)
		{
			
			while(!stck.isEmpty() && stck.peek() <= nums[i]) 
			{
				ans[stck.peek()] = nums[i];
				stck.pop();
			}
			stck.push(nums[i]);
		}

		
		return ans;
	}
	

}

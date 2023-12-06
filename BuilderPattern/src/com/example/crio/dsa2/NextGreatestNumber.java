package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextGreatestNumber {
	
	static void swap(char[] digit, int i ,int j){
		 char temp = digit[i];
		 digit[i] = digit[j];
		 digit[j] = temp;
		
   }
	
	static void nextSmall(char[] digit,int i){
		int nextSmall= Integer.MAX_VALUE;
		int nextSmallIndex=0;
		for (int j=digit.length-1;j>i;j--)
		{
		 if(digit[j] < nextSmall)
		 {
			 nextSmall = digit[j];
			 nextSmallIndex= j;
		 }
		}
		 swap(digit,i,nextSmallIndex);
		 Arrays.sort(digit,i+1,digit.length);
  }
	
	
	static int nextGreaterElementWithSameSetOfDigits(int n){
		
		char[] digit = String.valueOf(n).toCharArray();
		int j;
		for (j=digit.length-1;j>0;j--)
		{
			if (digit[j-1]< digit[j])
			{
				
				
				break;
			}
			
		}
		if (j == 0)
			return -1;
		else {
			int x = digit[j - 1];
			int min = j;

			for (int i = j; i < digit.length; i++) {
				if (digit[i] > x && digit[i] < digit[min]) {
					min = i;
				}

			}
			swap(digit,j-1,min);
			 Arrays.sort(digit,j,digit.length);
		}
		
		
		return Integer.valueOf(new String(digit));
		
    }
	
	
	public static void main(String[] args) {

		int input = 86941;
		System.out.println(nextGreaterElementWithSameSetOfDigits(input));
			}


}

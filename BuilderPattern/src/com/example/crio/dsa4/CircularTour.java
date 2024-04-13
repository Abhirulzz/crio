package com.example.crio.dsa4;

import java.util.ArrayList;

public class CircularTour {
	
	public static void main(String[] args) {

		int gas[] =  { 3,3,3 } ;
		String exp ="86 78 41 44 5 50 81 29 29 99 98 9 9 22 53 11 67 34 4 64 35 55 17 8 3 43 23 6 88 69 4 14 23 43 31 9 43 36 26 73 49 36 83 95 55 8 71 42 45 84 20 85 64 15 76 23 43 97 90 46 99 59 8 13 21 76 78 83 51 37 65 30 53 63 52 67 9 72 45 27 69 28 97 7 85 49 56";
		String ch[]= exp.split(" ");
		//int gas[] =  { 5 ,1, 2, 3, 4 } ;
		
		ArrayList<Integer> gasArray = new ArrayList<>();;
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			
			gasArray.add(Integer.valueOf(ch[i]));
			
			//count=count+ Integer.valueOf(ch[i]);
			
		}
		System.out.println("gascount" + count);
		int dist[] =  { 3,3,3 } ;
		//int dist[] =  { 4, 2, 3, 1, 5 } ;
		String dis = "62 27 24 83 42 24 36 53 50 50 39 27 42 84 44 34 32 90 11 24 46 71 42 85 39 65 43 88 51 68 4 88 40 49 63 26 11 35 5 19 23 46 91 72 57 92 10 62 50 91 4 26 65 72 69 80 37 78 34 51 11 33 13 63 58 34 84 93 21 48 99 75 13 83 16 44 96 7 95 19 10 69 31 58 70 35 9";
		String ch1[]= dis.split(" ");
		ArrayList<Integer> distArray = new ArrayList<>();;
		int count1 = 0;
		for (int i = 0; i < ch1.length; i++) {
			
			distArray.add(Integer.valueOf(ch1[i]));
			//count1=count1+ Integer.valueOf(ch1[i]);
			
		}
		System.out.println("distcount" + count1);
		int ans = circularRace(distArray.size(),gasArray,distArray);
		
		System.out.println( ans);

	}
	

	
	static int circularRace(int n, ArrayList<Integer>gas, ArrayList<Integer>dist){
		
		int balance =0;
		int index =0;
		int pastBalance =0;
		int i =0;
		while( i <n)
		{
			
			//18 
			
			balance = balance + gas.get(i) - dist.get(i);
			i++;
			if (balance < 0)
			{
				pastBalance =pastBalance + balance;
				balance = 0;
				index = i;
			}
			//i++;

		}
		if (balance +  pastBalance >= 0)
		return index +1;
		else 
			return -1;
    }
}

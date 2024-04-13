package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.Collections;

public class BeesAndHive {
	
	public static void main(String[] args) {

		int bees[] =  { 2,5,5,9 } ;

		ArrayList<Integer> beesPositions = new ArrayList<>();;
		
		for (int i = 0; i < bees.length; i++) {
			
			beesPositions.add(bees[i]);
		}
		
		int hive[] =  { 2,5,5,9 } ;

		ArrayList<Integer> hivesPositions = new ArrayList<>();;
		
		for (int i = 0; i < hive.length; i++) {
			
			hivesPositions.add(hive[i]);
		}
		
		int ans = beesToHives(bees.length,beesPositions,hivesPositions);
		
		System.out.println( ans);

	}
	
public static int beesToHives(int n,ArrayList<Integer> beesPositions,ArrayList<Integer> hivesPosition){
		Collections.sort(beesPositions);
		Collections.sort(hivesPosition);
		
		int time =0;
		for (int i = 0; i < n; i++) {
			
			time = Math.max(time, Math.abs(Math.abs(beesPositions.get(i)) - Math.abs(hivesPosition.get(i))) );
		}
		
        return time;
    }

}

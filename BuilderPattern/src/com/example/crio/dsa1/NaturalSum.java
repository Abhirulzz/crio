package com.example.crio.dsa1;

import java.util.Scanner;

public class NaturalSum {
	
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = naturalSum(n);
        System.out.println(res);
    }

    static int naturalSum(int n){

        int sum = n*(n+1)/2;
        return sum;
    }

}

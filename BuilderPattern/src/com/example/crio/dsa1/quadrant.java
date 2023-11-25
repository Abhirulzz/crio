package com.example.crio.dsa1;

import java.util.Scanner;

public class quadrant {
	
	    // NOTE: Please do not modify this function
	    public static void main(String args[]) {

	        Scanner sc = new Scanner(System.in);
	        System.out.println("Give x and y");
	        float x = sc.nextFloat();
	        float y = sc.nextFloat();

	        int result = findQuadrant(x, y);
	        System.out.println("Result is" +result);

	    }

	    // TODO: Implement this method
	    static int findQuadrant(float x, float y) {
	        if (x <0 && y > 0)
	        {
	            return 2;
	        }
	        else if (x > 0 &&  y >0)
	        {
	            return 1;
	        }
	        else if (x <0 && y < 0)
	        {
	            return 3;
	        }
	        else if (x > 0 && y < 0)
	        {
	            return 4;
	        }
	        else 
	        {
	        	return 0;
	        }
	    }
	}

	


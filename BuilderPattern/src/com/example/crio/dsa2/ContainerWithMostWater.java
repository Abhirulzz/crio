package com.example.crio.dsa2;

import java.util.Arrays;

public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int answer = 0;
		int area;

		//int prefix[] = new int[height.length];
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			area = (r - l) * Math.min(height[l], height[r]);
			if (height[l] < height[r])
				l++;
			else
				r--;

			if (answer < area) {
				answer = area;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println("Given Array is");
		int arr[] = new int[] { 9, 5, 6, 7, 3};
		System.out.println(Arrays.toString(arr));

		int centerElement = maxArea(arr);

		System.out.println("ContainerWithMostWater is");
		System.out.println(centerElement);
	}

}

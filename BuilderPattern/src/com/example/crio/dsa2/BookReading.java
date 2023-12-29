package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.List;

public class BookReading {

	public static int minSpeedToFinishBooks(int[] piles, int h) {
		int left = 1, right = getMax(piles);

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (isPossible(piles, h, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean isPossible(int[] piles, int h, int speed) {
		System.out.println("speed" + speed);
		double hoursNeeded = 0;

		for (int pile : piles) {
			hoursNeeded += (int)Math.ceil((double)pile / speed);
			System.out.println("for hoursneeded " +hoursNeeded );
		}
		//System.out.println("hoursNeeded" + hoursNeeded);
		return hoursNeeded <= h;
	}

	private static int getMax(int[] piles) {
		int max = Integer.MIN_VALUE;

		for (int pile : piles) {
			max = Math.max(max, pile);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;

		int result = minSpeedToFinishBooks(piles, h);
		System.out.println(result);
	}
}

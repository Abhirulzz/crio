package com.examples.designPattern;

public class PatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Input : aabbbcccddaee

		// Output : a2b3c3d2a1e2
		String input = "aabbbcccddaee";
		String output = null;
		// Char[] inp = input.
		// printRLE(input);
		int[] arr = { 1, 4, 6, 2, 3 };
		int[] result = printRLE(arr, 5, 2);
		for (int i = 0; i < result.length; i++)
			System.out.println("Element at index " + i + " : " + result[i]);
	}

	static void printRLE(String s) {
		for (int i = 0; i < s.length(); i++) {

			// Counting occurrences of s[i]
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			System.out.print(s.charAt(i) + String.valueOf(count));
		}

		System.out.println();
	}

	static int[] printRLE(int[] arr, int N, int K) {
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {

			// Counting occurrences of s[i]
			if (result[i] <= 0) {
				int j = i + 1;
				boolean notFound = true;
				while (j < N) {
					if ((arr[i] <= arr[j] + K) && arr[i] >= arr[j] - K) {
						result[i] = j + 1;
						result[j] = i + 1;
						notFound = false;
						break;
					} else {
						j++;
					}
				}
				if (notFound)
					result[i] = -1;
			}

		}

		return result;
	}

}
package com.examples.java8;

public class CommaFunction{

    public static String getCommaString(int input) {
        String s = Integer.toString(input);
        int n = s.length();

        // If the string length is less than or equal to 3, return it as is
        if (n <= 3) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int start = n % 3;

        // Append the first part if it's not a complete group of three
        if (start > 0) {
            result.append(s.substring(0, start)).append(",");
        }

        // Append the rest in groups of three
        for (int i = start; i < n; i += 3) {
            result.append(s.substring(i, i + 3)).append(",");
        }

        // Remove the trailing comma
        result.setLength(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args) {
        int number = 1234567;
        System.out.println(getCommaString(number));  // Output: 1,234,567
    }
}


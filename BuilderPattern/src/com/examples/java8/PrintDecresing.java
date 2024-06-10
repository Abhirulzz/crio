package com.examples.java8;

import java.util.stream.IntStream;

public class PrintDecresing {

	public static void main(String[] args) {
		int start = 0;  // inclusive
        int end = 11;    // exclusive
 
        IntStream.range(start, end)
                .map(i -> 100   - (10*i))
                .forEach(System.out::println);

	}

}

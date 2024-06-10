package com.example.educative.multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class ForkJoinSum extends RecursiveTask<Long> {
	


	    private static final int THRESHOLD = 10_000; // Threshold for splitting tasks
	    private final long[] array;
	    private final int start;
	    private final int end;

	    public ForkJoinSum(long[] array, int start, int end) {
	        this.array = array;
	        this.start = start;
	        this.end = end;
	    }

	    @Override
	    protected Long compute() {
	        int length = end - start;
	        if (length <= THRESHOLD) {
	            long sum = 0;
	            for (int i = start; i < end; i++) {
	                sum += array[i];
	            }
	            return sum;
	        } else {
	            int mid = start + length / 2;
	            ForkJoinSum leftTask = new ForkJoinSum(array, start, mid);
	            ForkJoinSum rightTask = new ForkJoinSum(array, mid, end);
	            Thread t = new Thread(new Runnable
	            		 {
	            	
	            });

	            leftTask.fork(); // asynchronously execute the left task
	            long rightResult = rightTask.compute(); // compute the right task synchronously
	            long leftResult = leftTask.join(); // wait for the left task to complete and get its result

	            return leftResult + rightResult;
	        }
	    }

	    public static void main(String[] args) {
	        long[] array = new long[20_000];
	        for (int i = 0; i < array.length; i++) {
	            array[i] = i + 1;
	        }

	        ForkJoinPool pool = new ForkJoinPool();
	        ForkJoinSum task = new ForkJoinSum(array, 0, array.length);
	        long sum = pool.invoke(task);

	        System.out.println("Sum: " + sum);
	    }
	}




package com.codedecode.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Imageprocesser {
	
	
	    private ExecutorService executor;

	    public Imageprocesser() {
	        // Create a fixed-size thread pool with 5 threads
	        executor = Executors.newFixedThreadPool(5);
	    }

	    public void processImage(String imageUrl) {
	        // Submit the image processing task to the executor
	        executor.submit(() -> {
	            // Simulating image processing by sleeping for a while
	            try {
	                System.out.println("Processing image from URL: " + imageUrl);
	                Thread.sleep(2000); // Simulating processing time
	                System.out.println("Image processed: " + imageUrl);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });
	    }

	    public void shutdown() {
	        // Shutdown the executor when not needed anymore
	        executor.shutdown();
	    }

	    public static void main(String[] args) {
	    	Imageprocesser imageProcessor = new Imageprocesser();
	        // Simulate uploading 10 images
	        for (int i = 1; i <= 10; i++) {
	            String imageUrl = "http://example.com/image" + i + ".jpg";
	            imageProcessor.processImage(imageUrl);
	        }
	        // After processing all images, shutdown the executor
	        imageProcessor.shutdown();
	    }
	}



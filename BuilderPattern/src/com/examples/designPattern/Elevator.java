package com.examples.designPattern;

import java.util.PriorityQueue;

public  class Elevator {
		
	    int currentFloor;
	    String direction;
	    PriorityQueue<Integer> requestQueue;

	    public Elevator(int initialFloor) {
	        currentFloor = initialFloor;
	        direction = "stationary";
	        requestQueue = new PriorityQueue<>();
	    }

	    // Add a new request to the elevator's queue
	    public void addRequest(int requestedFloor) {
	        requestQueue.add(requestedFloor);
	    }

	    // Simulate moving the elevator to a requested floor
	    public void moveTo(int requestedFloor) {
	        if (requestedFloor > currentFloor) {
	            direction = "up";
	        } else if (requestedFloor < currentFloor) {
	            direction = "down";
	        } else {
	            direction = "stationary";
	        }
	        currentFloor = requestedFloor;
	        System.out.println("Elevator moved to floor " + currentFloor);
	    }

	    // Get the estimated time to reach a requested floor
	    public int getEstimatedTime(int requestedFloor) {
	        return Math.abs(requestedFloor - currentFloor);
	    }
	}



	
	



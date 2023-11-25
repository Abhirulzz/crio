package com.examples.designPattern;

import java.util.PriorityQueue;

public class ElevatorControlSystem {

	    PriorityQueue<Elevator> elevatorQueue;

	    public ElevatorControlSystem(int numElevators ) {
	        elevatorQueue = new PriorityQueue<>((e1, e2) -> {
	            int time1 = e1.getEstimatedTime(0); // Example: Requested floor 0
	            int time2 = e2.getEstimatedTime(0);
	            return Integer.compare(time1, time2);
	        });

	        for (int i = 0; i < numElevators; i++) {
	            elevatorQueue.add(new Elevator(0,i)); // Initialize elevators on floor 0
	        }
	    }

	    // Request an elevator to a specific floor
	    public Elevator requestElevator(int requestedFloor) {
	        Elevator nearestElevator = elevatorQueue.poll();
	        nearestElevator.addRequest(requestedFloor);
	            elevatorQueue.add(nearestElevator);
	        nearestElevator.moveTo(requestedFloor);// Re-add the elevator with updated estimated time
	        return nearestElevator;
	    }

	    public static void main(String[] args) {
	        ElevatorControlSystem controlSystem = new ElevatorControlSystem(3); // Create 3 elevators
	        Elevator elevator = controlSystem.requestElevator(5); // Request an elevator to floor 5
	      // elevator.moveTo(5); // Simulate moving the elevator to floor 5
	       
	   /*     elevator.moveTo(1); 
	        elevator.moveTo(2); 
	        elevator.moveTo(3); 
	        elevator.moveTo(2); */
	       Elevator elevator1 = controlSystem.requestElevator(2);
	 	   // elevator1.moveTo(3);
	 	    Elevator elevator4 = controlSystem.requestElevator(4);
	 	   // elevator4.moveTo(4);
	 	    Elevator elevator2 = controlSystem.requestElevator(1);
	      //  elevator2.moveTo(1);
	        Elevator elevator3 = controlSystem.requestElevator(5);
	     //   elevator3.moveTo(2); */
	        Elevator elevator5 = controlSystem.requestElevator(3);
	        
	        Elevator elevator6 = controlSystem.requestElevator(5);
	        
	        Elevator elevator7 = controlSystem.requestElevator(4);
	        
	        
	    }
	    
	    public  class Elevator {
			int id;
		    int currentFloor;
		    String direction;
		    PriorityQueue<Integer> requestQueue;

		    public Elevator(int initialFloor, int id) {
		    	this.id= id;
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
		        System.out.println("Elevator " + id  + " moved to floor " + requestedFloor + " from " + currentFloor);
		        currentFloor = requestedFloor;
		        System.out.println();
		        //System.out.println("Elevator " + id  + " moved to floor " + currentFloor);
		    }

		    // Get the estimated time to reach a requested floor
		    public int getEstimatedTime(int requestedFloor) {
		        return Math.abs(requestedFloor - currentFloor);
		    }
		}
	}




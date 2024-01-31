package com.example.crio.dsa1;

import java.util.HashSet;

public class LinkedList {

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println(); 
		
	    
	    }  
	
	public static void printList1(ListNode head) {
		
	    
	        ListNode current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");  
	        }  
	        else {  
	            System.out.println("Nodes of the circular linked list: ");  
	             do{  
	                //Prints each node by incrementing pointer.  
	                System.out.print(" "+ current.val);  
	                current = current.next;  
	            }while(current != head);  
	            System.out.println();  
	        }  
	    }  
	

	public static void main(String[] args) {
		// Example usage:
		//ListNode head = null; 97 98 99 0 1 2 3
		//1 2 3 4 7
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		//head.next.next.next.next.next = new ListNode(2);
		//head.next.next.next.next.next.next = new ListNode(3);
		//head.next.next.next.next.next = head; 
		
		//4 5 9 10 0 1 2
		System.out.println("Original Linked List:");
		printList(head);

		removeDuplicates(head);
		printList(head);
		//ListNode reverse = reverseLinkedList(head);
		//System.out.println("reverse");
		//printList(reverse);
		//ListNode moveMiddleToHead = moveMiddleToHead(reverse);
		//System.out.println("moveMiddleToHead");
		//printList(moveMiddleToHead);
		//ListNode insertIntoRotatedSortedCircularList = insertIntoRotatedSortedCircularList(head,6);
		//System.out.println("insertIntoRotatedSortedCircularList");
		//printList1(insertIntoRotatedSortedCircularList);
		
		//deleteKthToLast
		deleteNode(head.next.next);
		System.out.println("deleteKthToLast");
		printList1(head);

		//System.out.println("Even Linked List:");
		//printList(head);

	}
	
	public static ListNode moveMiddleToHead(ListNode head) {
		if (head == null)
			return head;

		if (head.next == null) {
			return head;
		}

		// To traverse list nodes one
		// by one
		ListNode one_node = head;

		// To traverse list nodes by
		// skipping one.
		ListNode two_node = head;

		// To keep track of previous of middle
		ListNode prev = null;
		
		while (two_node != null && two_node.next != null) {

			/* for previous node of middle node */
			prev = one_node;

			/* move one node each time */
			two_node = two_node.next.next;

			/* move two node each time */
			one_node = one_node.next;
		}

		/* set middle node at head */
		prev.next = prev.next.next;
		one_node.next = head;
		head = one_node;

		return head;
	}
	
	public static ListNode reverseLinkedList(ListNode head) {
		if (head == null) {
			return head;
		}
		int count = 0;

		// last node or only one node
		if (head.next == null) {
			count++;
			return head;
			
		}
		
		

		ListNode newHeadNode = reverseLinkedList(head.next);

		// change references for middle chain
		head.next.next = head;
		head.next = null;
		count++;
		

		// send back new head node in every recursion
		return newHeadNode;
	}
	
	public static ListNode reverseLinkedListItereratively(ListNode head) {
		if (head == null) {
			return head;
		}

		// last node or only one node
		if (head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		
		while (current != null) {
			next = current.next;
			current.next=prev;
			prev=current;
			current = next;
		}
		

		// send back new head node in every recursion
		return prev;
	}
	
	public static ListNode deleteKthToLast(ListNode head, int k) {
		if (head == null)
			return head;

		if (head.next == null) {
			return null;
		}

		// To traverse list nodes one
		// by one
		ListNode one_node = head;

		// To traverse k node ahead
		
		int count =1;
		ListNode two_node = head;
		while(count < k)
		{
			two_node =two_node.next;
			count++;
		}

		// To keep track of previous of middle
		ListNode prev = null;
		
		while (two_node != null && two_node.next != null) {

			/* for previous node of middle node */
			prev = one_node;

			/* move one node each time */
			two_node = two_node.next;

			/* move two node each time */
			one_node = one_node.next;
		}

		/* delete the node */
		if(prev != null)
		prev.next = prev.next.next;
		else
		head =head.next;
		

		return head;
	}
	
	public static void deleteNode(ListNode node) {
		ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
	}
	
	
	public static void removeDuplicates(ListNode head) {
		HashSet<Integer> set = new HashSet<>();

		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			int currentData = current.val;

			// If the current data is already in the HashSet, remove the current node
			if (set.contains(currentData)) {
				prev.next = current.next;
			} else {
				// Add the current data to the HashSet
				set.add(currentData);
				prev = current;
			}

			// Move to the next node
			current = current.next;
		}

	}
	
	
	public static ListNode insertIntoSortedCircularList(ListNode head,int insertVal)
	{
		ListNode newNode = new ListNode(insertVal);

        // If the list is empty or the new node data is less than the head data
        if (head == null || insertVal < head.val) {
            newNode.next = head;
            head = newNode;
            return head;
        } 

        // Find the correct position to insert the new node
        ListNode current = head;
        while (current.next != null && current.next.val < insertVal) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
         return head;
	}
	
	public static ListNode insertIntoRotatedSortedCircularList(ListNode head,int insertVal)
	{
	ListNode newNode = new ListNode(insertVal);

        // If the list is empty
        if (head == null) {
            head = newNode;
            head.next=head;
            return head;
        }

        // Find the correct position to insert the new node
        ListNode current = head;

        // Loop to find the last node before rotation
        while (current.next != null && current.next.val > current.val) {
            current = current.next;
        }
         
        ListNode start = current.next;

        //System.out.println("curr" + current);

        // Loop to find the correct position after rotation
        //ListNode temp = head;
        while ( current.next.val < insertVal ) {
            current = current.next;
            if(current.next == start)
            	break;
            
        }

        newNode.next = current.next;
        current.next = newNode;
        
        return head;
	}
	// System.out.println(set);

}

package com.example.crio.dsa1;

public class RemoveCycle {
	
	
	    public static void removeCycle(ListNode head) {
	        if (head == null || head.next == null) {
	            return;
	        }

	        ListNode slow = head;
	        ListNode fast = head;

	        // Detect the cycle
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;

	            if (slow == fast) {
	                // Cycle detected, break the cycle
	                removeCycleAtNode(head, slow);
	                return;
	            }
	        }
	    }

	    private static void removeCycleAtNode(ListNode head, ListNode intersectionNode) {
	        ListNode ptr1 = head;
	        ListNode currentHead = head;
	        ListNode ptr2 = intersectionNode;

	        // Move one pointer to the start and then move both pointers one step at a time until they meet
	        while (ptr1.next != ptr2.next) {
	            ptr1 = ptr1.next;
	            ptr2 = ptr2.next;
	        }

	        // Set the next of the meeting point to null, breaking the cycle
	        if(head == intersectionNode)
	        {
	        	while(head.next != currentHead)
	        	{
	        		head=head.next;
	        	}
	        	head.next = null;
	        }
	        else
	        	
	        ptr2.next = null;
	    }

	    public static void main(String[] args) {
	        //RemoveLinkedListCycle removeCycle = new RemoveLinkedListCycle();

	        // Example usage:
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(0);
	        head.next.next.next = new ListNode(4);
	        
	        // Creating a cycle for testing
	        head.next.next.next.next = head;
	        printList2(head, head.next.next.next);
	        // Removing the cycle
	        removeCycle(head);

	        // Check if the cycle has been removed
	        //boolean hasCycle = new LinkedListCycleDetection().hasCycle(head);
	        printList(head);
	    }
	    
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
	    
		public static void printList2(ListNode head ,ListNode intersection) {

			ListNode current = head;
			ListNode prev = head;
			if (head == null) {
				System.out.println("List is empty");
			} else {
				System.out.println("Nodes of the circular linked list: ");
				while (prev != intersection) {
					// Prints each node by incrementing pointer.
					prev = current;
					System.out.print(" " + current.val);
					current = current.next;
				} 
				System.out.println();
			}
		}  
	}




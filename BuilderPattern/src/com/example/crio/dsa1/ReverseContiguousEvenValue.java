package com.example.crio.dsa1;

public class ReverseContiguousEvenValue {
	
	
	
	// Recursive function to reverse the consecutive
	// even nodes of the linked list
	static ListNode reverse(ListNode head, ListNode prev)
	{

		// Base case
		if (head == null)
			return null;

		ListNode temp;
		ListNode curr;
		curr = head;

		// Reversing nodes until curr node's value
		// turn odd or Linked list is fully traversed
		while (curr != null && curr.val % 2 == 0) 
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		// If elements were reversed then head
		// pointer needs to be changed
		if (curr != head) 
		{
			head.next = curr;

			// Recur for the remaining linked list
			curr = reverse(curr, null);
			return prev;
		}

		// Simply iterate over the odd value nodes
		else
		{
			head.next = reverse(head.next, head);
			return head;
		}
	}

	
	

	// This code is contributed by PrinciRaj1992

	
	

	    public static ListNode reverseContiguousEvenValues(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }

	        ListNode evenHead = null;
	        ListNode evenTail = null;
	        ListNode prev = null;

	        // Traverse the list to find and reverse even values
	        ListNode current = head;

	        while (current != null) {
	            if (current.val % 2 == 0) {
	                // Found an even value, reverse the even values
	                ListNode evenStart = current;
	                while (current != null && current.val % 2 == 0) {
	                    ListNode nextNode = current.next;
	                    current.next = evenHead;
	                    evenHead = current;
	                    current = nextNode;
	                }

	                if (evenTail == null) {
	                    // Update head if reversing starts from the beginning
	                    head = evenHead;
	                } else {
	                    // Connect the reversed even values to the previous tail
	                    evenTail.next = evenHead;
	                }

	                evenTail = evenStart;
	            } else {
	                // Continue with odd values
	                if (evenTail != null) {
	                    evenTail.next = current;
	                } else {
	                    head = current;
	                }

	                prev = evenTail;
	                evenTail = null;
	                current = current.next;
	            }
	        }

	        // Connect the last segment of the list
	        if (evenTail != null) {
	            evenTail.next = null;
	        }

	        return head;
	    }

	    public static void printLinkedList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }
	        System.out.println("null");
	    }

	    public static void main(String[] args) {
	        // Example usage:
	        // Input:  1 -> 2 -> 3 -> 4 -> 6 -> 8 -> 5
	        // Output: 1 -> 8 -> 3 -> 6 -> 4 -> 2 -> 5
	        ListNode originalList = new ListNode(1);
	        originalList.next = new ListNode(2);
	        originalList.next.next = new ListNode(3);
	        originalList.next.next.next = new ListNode(4);
	        originalList.next.next.next.next = new ListNode(6);
	        originalList.next.next.next.next.next = new ListNode(8);
	        originalList.next.next.next.next.next.next = new ListNode(5);

	        System.out.println("Original List:");
	        printLinkedList(originalList);

	        ListNode reversedList = reverse(originalList,null);

	        System.out.println("\nList with Reversed Contiguous Even Values:");
	        printLinkedList(reversedList);
	    }
	}




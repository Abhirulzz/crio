package com.example.crio.dsa1;

import java.util.ArrayList;
import java.util.List;

public class SplitLinkedListOddEven {
	
	public static List<ListNode> splitOddEven(ListNode head) {
		 if (head == null || head.next == null) {
	            return null;
	        }

	        ListNode oddHead = new ListNode(0);
	        ListNode evenHead = new ListNode(0);
	        ListNode oddCurrent = oddHead;
	        ListNode evenCurrent = evenHead;

	        while (head != null) {
	            if (head.val % 2 == 0) {
	                evenCurrent.next = head;
	                evenCurrent = evenCurrent.next;
	            } else {
	                oddCurrent.next = head;
	                oddCurrent = oddCurrent.next;
	            }

	            head = head.next;
	        }

	        evenCurrent.next = null; // Set the last node of the even list to null
	        oddCurrent.next = evenHead.next; // Connect odd list to even list

	        List<ListNode> result = new ArrayList<>();
	        result.add(oddHead.next);
	        result.add(evenHead.next);

	        return result;
    }
	
	public static ListNode splitOddEvenIndices(ListNode head) {
		 if (head == null || head.next == null) {
	            return null;
	        }

	        ListNode oddHead = new ListNode(0);
	        ListNode evenHead = new ListNode(0);
	        ListNode oddCurrent = oddHead;
	        ListNode evenCurrent = evenHead;
	        int i  = 1;
	        while (head != null) {
	            if (i%2 == 0) {
	                evenCurrent.next = head;
	                evenCurrent = evenCurrent.next;
	            } else {
	                oddCurrent.next = head;
	                oddCurrent = oddCurrent.next;
	            }

	            head = head.next;
	            i++;
	        }
	        //oddCurrent.next = null; 
	        evenCurrent.next = null; // Set the last node of the even list to null
	        oddCurrent.next = evenHead.next; // Connect odd list to even list

	        List<ListNode> result = new ArrayList<>();
	        result.add(oddHead.next);
	        result.add(evenHead.next);

	        return oddHead.next;
   }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(23);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(45);
        head.next.next.next.next = new ListNode(56);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode result = splitOddEvenIndices(head);

       /* System.out.println("Odd Linked List:");
        printList(result.get(0));

        System.out.println("Even Linked List:");
        printList(result.get(1)); */
    }

}

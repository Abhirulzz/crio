package com.example.crio.dsa1;



public class ReorderLinkedList {

    public static ListNode reorderLinkedList(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode dummy3 = new ListNode(0);
        ListNode before = dummy1;
        ListNode after = dummy2;
        ListNode equal = dummy3;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else if (head.val == x) {
                equal.next = head;
                equal = equal.next;
            }else
            {
            	after.next = head;
                after = after.next;	
            }
            head = head.next;
            System.out.println();
        }

        after.next = null; // Set the end of the second part to null to avoid cycles

        // Reverse the second part of the linked list
        //ListNode reversedAfter = reverseList(dummy2.next);

		// Merge the two parts back together
		if (dummy3.next != null)
			before.next = dummy3.next;
		else
			before.next = dummy2.next;
		if (dummy2.next != null)
			equal.next = dummy2.next;
		else
			equal.next = null;
		if (dummy1.next != null)
			head = dummy1.next;
		else
			head = dummy2.next;
        
        
        return head;

        // The reordered linked list is in dummy1.next
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
    	//3 5 8 5 10 2 1
    	//3 1 3 1 4
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next = new ListNode(2);
        //head.next.next.next.next.next.next = new ListNode(1);

        int x = 2;
        
      

        ListNode reorderLinkedList = reorderLinkedList(head, x);

        // Print the reordered linked list
        while (reorderLinkedList != null) {
            System.out.print(reorderLinkedList.val + " ");
            reorderLinkedList = reorderLinkedList.next;
        }
    }
}

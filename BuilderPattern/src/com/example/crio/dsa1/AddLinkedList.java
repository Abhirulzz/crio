package com.example.crio.dsa1;

public class AddLinkedList {

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		ListNode l1 =  reverseList(head1);
		ListNode l2 =  reverseList(head2);
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null) {
			System.out.println(l1.val);
			System.out.println(l2.val);
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;

			int sum = x + y + carry;
			carry = sum / 10;

			current.next = new ListNode(sum % 10);
			current = current.next;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return  reverseList(dummyHead.next);
	}
	
	
	private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
	
	

	public static void main(String[] args) {
		// Example usage:
		// Input:
		// List 1: 2 -> 4 -> 3 (represents the number 342)
		// List 2: 5 -> 6 -> 4 (represents the number 465)
		// Output:
		// Result: 7 -> 0 -> 8 (represents the number 807)
		ListNode list1 = new ListNode(3);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(2);

		ListNode list2 = new ListNode(4);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(5);

		ListNode result = addTwoNumbers(list1, list2);

		// Print the result
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}
}

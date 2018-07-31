package reverseLinkedList2;

// LeetCode #92 (Reverse Linked List II).

// Reverse a linked list from position m to n. Do it in one-pass.

// Note: 1 ≤ m ≤ n ≤ length of list.

public class ReverseLinkedList2 {

	// draw the linked list, and you should be able to see...
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int count = 0;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = null, cur = dummy;
		while (count < m) {
			count++;
			prev = cur;
			cur = cur.next;
		}
		ListNode tail = prev, next = cur.next;
		prev = null;
		while (count <= n) {
			count++;
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		next = tail.next;
		tail.next = prev;
		next.next = cur;
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

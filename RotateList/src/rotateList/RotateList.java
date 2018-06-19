package rotateList;

// LeetCode #61 (Rotate List).

// Given a linked list, rotate the list to the right by k places, where k is non-negative.

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		int length = length(head);
		if (length == 0 || k % length == 0) {
			return head;
		}
		k = k % length;

		ListNode slow = head, fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}

	private int length(ListNode head) {
		int length = 0;
		ListNode cur = head;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

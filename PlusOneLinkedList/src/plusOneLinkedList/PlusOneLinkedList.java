package plusOneLinkedList;

// LeetCode #369 (Plus One Linked List).

// Given a non-negative integer represented as non-empty a singly linked list of digits, 
// plus one to the integer.

// You may assume the integer do not contain any leading zero, except the number 0 itself.

// The digits are stored such that the most significant digit is at the head of the list.

public class PlusOneLinkedList {

	// Solution 1: reverse linked list
	public ListNode plusOne(ListNode head) { // head != null
		ListNode newHead = reverse(head);
		ListNode cur = newHead, prev = null;
		while (cur != null && cur.val == 9) {
			prev = cur;
			cur.val = 0;
			cur = cur.next;
		}
		if (cur == null) {
			prev.next = new ListNode(1);
		} else {
			cur.val += 1;
		}
		return reverse(newHead);
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head, prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Solution 2: two pointers
	public ListNode plusOne2(ListNode head) { // head != null
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		// slow is the last node whose value is not equal to 9, and slow can be dummy
		while (fast.next != null) {
			if (fast.next.val != 9) {
				slow = fast.next;
			}
			fast = fast.next;
		}

		if (fast.val < 9) {
			fast.val++;
		} else {
			slow.val++;
			slow = slow.next;
			while (slow != null) {
				slow.val = 0;
				slow = slow.next;
			}
		}
		
		return dummy.val == 0 ? dummy.next : dummy;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

package removeDuplicatesFromSortedList;

// LeetCode #83

// Given a sorted linked list, delete all duplicates such that each element appear only once.

public class RemoveDuplicatesFromSortedList {

	// Iterative Solution
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				ListNode temp = cur.next;
				cur.next = temp.next;
				temp.next = null; // GC
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Recursive Solution
	public ListNode deleteDuplicates2(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		// recursive rule
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

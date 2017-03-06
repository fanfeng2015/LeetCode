package removeDuplicatesFromSortedList;

// LeetCode #83

// Given a sorted linked list, delete all duplicates such that each element appear only once.

public class RemoveDuplicatesFromSortedList {

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
}

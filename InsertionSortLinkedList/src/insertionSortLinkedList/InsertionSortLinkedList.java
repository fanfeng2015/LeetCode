package insertionSortLinkedList;

// LeetCode #147

// Sort a linked list using insertion sort.

public class InsertionSortLinkedList {

	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode cur = head, next = null;
		while (cur != null) {
			next = cur.next;
			ListNode prev = dummy;
			while (prev.next != null && prev.next.val < cur.val) {
				prev = prev.next;
			}
			// insert cur between prev and prev.next
			cur.next = prev.next;
			prev.next = cur;
			cur = next;
		}
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
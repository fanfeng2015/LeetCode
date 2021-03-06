package removeNthNodeFromEndOfList;

//LeetCode #19 (Remove Nth Node from End of Linked List).

//Given a linked list, remove the nth node from the end of list and return its head.

//Given n will always be valid. Try to do this in one pass.

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

package oddEvenLinkedList;

// LeetCode #328

// Given a singly linked list, group all odd nodes together followed by the even nodes. 
// Please note here we are talking about the node number and not the value in the nodes.

// You should try to do it in place. The program should run in O(1) space complexity and O(n) time complexity.

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode even = head, curEven = even;
		ListNode odd = head.next, curOdd = odd;
		boolean flag = true; // indicate even
		ListNode cur = odd.next;
		while (cur != null) {
			if (flag) {
				curEven.next = cur;
				curEven = curEven.next;
			} else {
				curOdd.next = cur;
				curOdd = curOdd.next;
			}
			cur = cur.next;
			flag = !flag;
		}
		if (flag) {
			curEven.next = null;
		} else {
			curOdd.next = null;
		}
		curEven.next = odd;
		return even;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

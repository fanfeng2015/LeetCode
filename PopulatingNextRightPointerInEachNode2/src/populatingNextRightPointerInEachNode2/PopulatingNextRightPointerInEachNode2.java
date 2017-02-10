package populatingNextRightPointerInEachNode2;

// LeetCode #117: follow-up of #116.

// What if the given tree could be any binary tree?
// You may only use constant extra space.

public class PopulatingNextRightPointerInEachNode2 {

	public void connect(TreeLinkNode root) {
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
			while (head != null) {
				if (head.left != null) {
					nextTail.next = head.left;
					nextTail = nextTail.next;
				}
				if (head.right != null) {
					nextTail.next = head.right;
					nextTail = nextTail.next;
				}
				head = head.next;
			}
			// next level
			head = nextHead.next;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

package populatingNextRightPointerInEachNode;

// LeetCode #116

// Given a binary tree, populate each next pointer to point to its next right node. 
// If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.
// You may only use constant extra space.
// You may assume that it is a PERFECT binary tree (ie, all leaves are at the same level, and every parent has two children).

public class PopulatingNextRightPointerInEachNode {

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode prev = root, cur = null;
		while (prev.left != null) {
			cur = prev;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			// next level
			prev = prev.left;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

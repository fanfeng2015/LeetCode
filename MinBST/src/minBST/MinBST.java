package minBST;

import java.util.LinkedList;

// LeetCode #173

// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

public class MinBST {

	private LinkedList<TreeNode> stack = new LinkedList<>();

	public MinBST(TreeNode root) {
		push(root);
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}

	public int next() {
		TreeNode cur = stack.pollLast();
		push(cur.right);
		return cur.val;
	}

	private void push(TreeNode root) {
		while (root != null) {
			stack.offerLast(root);
			root = root.left;
		}
	}
}

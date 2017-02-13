package kthSmallestInBST;

import java.util.LinkedList;

public class KthSmallestInBST {

	private int count = 0;
	private int result = 0;

	// Solution 1: recursive in-order
	public int kthSmallest(TreeNode root, int k) {
		inOrder(root, k);
		return result;
	}

	private void inOrder(TreeNode root, int k) {
		// base case
		if (root == null) {
			return;
		}
		inOrder(root.left, k);
		count++;
		if (count == k) {
			result = root.val;
			return;
		}
		inOrder(root.right, k);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: iterative in-order
	public int kthSmallest2(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.offerLast(root);
		TreeNode cur = root;
		while (cur != null || stack.size() != 0) {
			if (cur != null) {
				stack.offerLast(cur);
				cur = cur.left;
			} else {
				cur = stack.pollLast();
				k--;
				if (k == 0) {
					return cur.val;
				}
				cur = cur.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

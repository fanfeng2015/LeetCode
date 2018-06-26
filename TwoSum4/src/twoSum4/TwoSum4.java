package twoSum4;

import java.util.Stack;

// LeetCode #653 (Two Sum IV - Input is a BST).

// Given a Binary Search Tree and a target number, return true if there 
// exists two elements in the BST such that their sum is equal to the given
// target.

public class TwoSum4 {

	public boolean findTarget(TreeNode root, int k) {
		TreeNode left = root, right = root;
		Stack<TreeNode> leftStack = new Stack<>(), rightStack = new Stack<>();
		pushLeft(left, leftStack);
		pushRight(right, rightStack);
		while (leftStack.peek() != rightStack.peek()) {
			int sum = leftStack.peek().val + rightStack.peek().val;
			if (sum == k) {
				return true;
			} else if (sum < k) {
				left = leftStack.pop();
				left = left.right;
				pushLeft(left, leftStack);
			} else {
				right = rightStack.pop();
				right = right.left;
				pushRight(right, rightStack);
			}
		}
		return false;
	}

	private void pushLeft(TreeNode left, Stack<TreeNode> leftStack) {
		while (left != null) {
			leftStack.push(left);
			left = left.left;
		}
	}

	private void pushRight(TreeNode right, Stack<TreeNode> rightStack) {
		while (right != null) {
			rightStack.push(right);
			right = right.right;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary search tree is highly unbalanced.
	// However in the average case, space complexity is O(log(n)).
}

package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

// LeetCode #257

// Given a binary tree, return all root-to-leaf paths.

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(root, result, sb);
		return result;
	}

	private void helper(TreeNode root, List<String> result, StringBuilder sb) {
		// base case
		if (root.left == null && root.right == null) {
			sb.append(root.val);
			result.add(sb.toString());
			sb.delete(sb.length() - String.valueOf(root.val).length(), sb.length());
			return;
		}
		// recursive rule
		sb.append(root.val).append("->");
		if (root.left != null) {
			helper(root.left, result, sb);
		}
		if (root.right != null) {
			helper(root.right, result, sb);
		}
		sb.delete(sb.length() - 2 - String.valueOf(root.val).length(), sb.length());
	}

	// Time complexity is O(n), thanks to StringBuilder.
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}

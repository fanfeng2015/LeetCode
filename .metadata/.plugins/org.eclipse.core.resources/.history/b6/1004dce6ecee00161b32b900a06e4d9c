package maximumDepthOfBinaryTree;

// LeetCode #104
// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		// root != null
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: BFS...
}

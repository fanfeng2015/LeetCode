package findLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

// LeetCode #366
// Given a binary tree, collect a tree's nodes as if you were doing this: 
// Collect and remove all leaves, repeat until the tree is empty.
// For example, given a binary tree [1, 2, 3, 4, 5, #, #], return [[4, 5, 3], [2], [1]].

public class FindLeavesOfBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, result);
		return result;
	}

	private int helper(TreeNode root, List<List<Integer>> result) {
		// base case
		if (root == null) {
			return -1;
		}
		// recursive rule
		int left = helper(root.left, result);
		int right = helper(root.right, result);
		int height = Math.max(left, right) + 1;
		if (result.size() < height + 1) {
			result.add(new ArrayList<Integer>());
		}
		result.get(height).add(root.val);
		return height;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, ignoring space needed
	// for output.
}

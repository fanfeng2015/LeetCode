package pathSum3;

import java.util.HashMap;
import java.util.Map;

// LeetCode #437

// You are given a binary tree in which each node contains an integer value.
// Find the number of paths that sum to a given value.

// The path does not need to start or end at the root or a leaf, but it must go downwards 
// (traveling only from parent nodes to child nodes).
// The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

public class PathSum3 {

	// Solution 1
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return helper(root, sum) + helper(root.left, sum) + helper(root.right, sum);
	}

	private int helper(TreeNode root, int sum) {
		int count = 0;
		if (root == null) {
			return count;
		}
		if (sum == root.val) {
			count++;
		}
		count += helper(root.left, sum - root.val);
		count += helper(root.right, sum - root.val);
		return count;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// Solution 2
	private int count = 0;

	public int pathSum2(TreeNode root, int sum) {
		Map<Integer, Integer> prefixSums = new HashMap<>();
		prefixSums.put(0, 1);
		helper2(root, prefixSums, 0, sum);
		return count;
	}

	private void helper2(TreeNode root, Map<Integer, Integer> prefixSums, int prevSum, int target) {
		if (root == null) {
			return;
		}
		prevSum += root.val;
		if (prefixSums.containsKey(prevSum - target)) {
			count += prefixSums.get(prevSum - target);
		}
		// base case
		Integer i = prefixSums.get(prevSum);
		i = (i == null) ? 1 : i + 1;
		prefixSums.put(prevSum, i);
		// recursive rule
		helper2(root.left, prefixSums, prevSum, target);
		helper2(root.right, prefixSums, prevSum, target);
		// decrement by 1
		prefixSums.put(prevSum, prefixSums.get(prevSum) - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
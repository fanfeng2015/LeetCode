package pathSum3;

import java.util.HashMap;
import java.util.Map;

// LeetCode #437 (Path Sum III).

// You are given a binary tree in which each node contains an integer value.
// Find the number of paths that sum to a given value.

// The path does not need to start or end at the root or a leaf, but it must go downwards 
// (traveling only from parent nodes to child nodes).
// The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

public class PathSum3 {

	private int count = 0;

	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> prefixSumMap = new HashMap<>();
		prefixSumMap.put(0, 1);
		pathSum(root, sum, 0, prefixSumMap);
		return count;
	}

	private void pathSum(TreeNode root, int target, int prefixSum, Map<Integer, Integer> prefixSumMap) {
		if (root == null) {
			return;
		}
		prefixSum += root.val;
		if (prefixSumMap.containsKey(prefixSum - target)) {
			count += prefixSumMap.get(prefixSum - target);
		}
		// increment
		Integer frequency = prefixSumMap.get(prefixSum);
		frequency = (frequency == null) ? 1 : frequency + 1;
		prefixSumMap.put(prefixSum, frequency);
		// dfs
		pathSum(root.left, target, prefixSum, prefixSumMap);
		pathSum(root.right, target, prefixSum, prefixSumMap);
		// decrement
		prefixSumMap.put(prefixSum, prefixSumMap.get(prefixSum) - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

package mostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #508

public class MostFrequentSubtreeSum {

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>(); // frequency map
		Integer[] max = new Integer[] { 0 }; // global max frequency
		helper(root, map, max);
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max[0]) {
				list.add(entry.getKey());
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private int helper(TreeNode root, Map<Integer, Integer> map, Integer[] max) {
		// base case
		if (root == null) {
			return 0;
		}
		// recursive rule
		int left = helper(root.left, map, max);
		int right = helper(root.right, map, max);
		add(left + right + root.val, map, max);
		return left + right + root.val;
	}

	private void add(int val, Map<Integer, Integer> map, Integer[] max) {
		Integer frequency = map.get(val);
		frequency = frequency == null ? 1 : frequency + 1;
		map.put(val, frequency + 1);
		// might need to update max frequency
		max[0] = Math.max(max[0], map.get(val));
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// Note: New features of Java 8 can make code more compact:
	// 1. map.getOrDefault(Object key, V defaultValue)
	// 2. list.stream().mapToInt(i -> i).toArray()
}

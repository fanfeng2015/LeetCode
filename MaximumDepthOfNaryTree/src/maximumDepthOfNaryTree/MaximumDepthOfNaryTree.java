package maximumDepthOfNaryTree;

import java.util.List;

// LeetCode #559 (Maximum Depth of N-ary Tree).

// Given a n-ary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the
// root node down to the farthest leaf node.

public class MaximumDepthOfNaryTree {

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		List<Node> children = root.children;
		if (children == null || children.size() == 0) {
			return 1;
		}
		int max = maxDepth(children.get(0));
		for (int i = 1; i < children.size(); i++) {
			int cur = maxDepth(children.get(i));
			if (cur > max) {
				max = cur;
			}
		}
		return max + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

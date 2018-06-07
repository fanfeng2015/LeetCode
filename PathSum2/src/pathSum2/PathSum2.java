package pathSum2;

import java.util.ArrayList;
import java.util.List;

// LeetCode #113 (Path Sum II).

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		int soFar = 0;
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		DFS(root, sum, soFar, cur, result);
		return result;
	}

	private void DFS(TreeNode root, int target, int soFar, List<Integer> cur, List<List<Integer>> result) {
		cur.add(root.val);
		soFar += root.val;
		// base case
		if (root.left == null && root.right == null) { // leaf node
			if (soFar == target) {
				result.add(new ArrayList<Integer>(cur));
			}
		}
		// recursive rule
		if (root.left != null) {
			DFS(root.left, target, soFar, cur, result);
		}
		if (root.right != null) {
			DFS(root.right, target, soFar, cur, result);
		}
		soFar -= cur.remove(cur.size() - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}

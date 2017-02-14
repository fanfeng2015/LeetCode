package pathSum2;

import java.util.ArrayList;
import java.util.List;

// LeetCode #113

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

public class PathSum2 {

	private int soFar;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		DFS(root, result, cur, sum);
		return result;
	}

	private void DFS(TreeNode root, List<List<Integer>> result, List<Integer> cur, int target) {
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
			DFS(root.left, result, cur, target);
		}
		if (root.right != null) {
			DFS(root.right, result, cur, target);
		}
		soFar -= cur.remove(cur.size() - 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
package houseRobber3;

// LeetCode #337

// The thief has found himself a new place for his thievery again. 
// There is only one entrance to this area, called the "root." 
// Besides the root, each house has one and only one parent house. 
// After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
// It will automatically contact the police if two directly-linked houses were broken into on the same night.

// Determine the maximum amount of money the thief can rob tonight without alerting the police.

public class HouseRobber3 {

	public int rob(TreeNode root) {
		int[] result = helper(root); // [rob, not rob]
		return Math.max(result[0], result[1]);
	}

	private int[] helper(TreeNode root) {
		// base case
		if (root == null) {
			return new int[] { 0, 0 };
		} else if (root.left == null && root.right == null) {
			return new int[] { root.val, 0 };
		}
		// root.left != null || root.right != null
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		return new int[] { root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

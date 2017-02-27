package convertSortedArrayToBST;

// LeetCode #108

// Given an array where elements are sorted in ascending order, 
// convert it to a height balanced BST.

public class ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		// base case
		if (left > right) {
			return null;
		}
		// recursive rule
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, left, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, right);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(log(n)).
}

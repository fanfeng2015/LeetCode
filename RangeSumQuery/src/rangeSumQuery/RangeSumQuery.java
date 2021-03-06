package rangeSumQuery;

// LeetCode #303

// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// Assumptions:
// 1. You may assume that the array does not change.
// 2. There are many calls to sumRange function.

public class RangeSumQuery {

	int[] nums;

	public RangeSumQuery(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		return nums[j] - (i == 0 ? 0 : nums[i - 1]);
	}

	// Time complexity is O(1).
	// Space complexity is O(n).
}

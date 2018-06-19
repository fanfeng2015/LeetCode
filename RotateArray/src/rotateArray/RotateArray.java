package rotateArray;

// LeetCode #189 (Rotate Array).

// Given an array, rotate the array to the right by k steps, where k is non-negative.

public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k % nums.length == 0) {
			return;
		}
		k = k % nums.length;
		rotate(nums, 0, nums.length - k - 1);
		rotate(nums, nums.length - k, nums.length - 1);
		rotate(nums, 0, nums.length - 1);
	}

	private void rotate(int[] nums, int left, int right) {
		while (left < right) {
			swap(nums, left++, right--);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

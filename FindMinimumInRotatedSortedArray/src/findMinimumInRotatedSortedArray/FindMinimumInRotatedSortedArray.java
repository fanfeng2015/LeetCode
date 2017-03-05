package findMinimumInRotatedSortedArray;

// LeetCode #153

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// Find the minimum element.

// Assumption: You may assume no duplicate exists in the array.

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[left] > nums[mid]) {
				// array drops on the left
				right = mid;
			} else if (nums[mid] > nums[right]) {
				// array drops on the right
				left = mid;
			} else {
				return nums[left];
			}
		}
		return Math.min(nums[left], nums[right]);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

package searchInsertPosition;

// LeetCode #35 (Search Insert Position).

// Given a sorted array and a target value, return the index if the target 
// is found. If not, return the index where it would be if it were inserted in order.

// Assumption: You may assume no duplicates in the array.

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return nums[right] < target ? right + 1 : nums[left] < target ? left + 1 : left;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

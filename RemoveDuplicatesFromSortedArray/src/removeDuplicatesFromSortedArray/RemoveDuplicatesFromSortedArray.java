package removeDuplicatesFromSortedArray;

// LeetCode #26

// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this in place with constant memory.

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[left]) {
				nums[++left] = nums[i];
			}
		}
		return left + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

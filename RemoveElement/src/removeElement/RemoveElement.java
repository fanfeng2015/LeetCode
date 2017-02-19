package removeElement;

// LeetCode #27

// Given an array and a value, remove all instances of that value in place and return the new length.
// Do not allocate extra space for another array, you must do this in place with constant memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int slow = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

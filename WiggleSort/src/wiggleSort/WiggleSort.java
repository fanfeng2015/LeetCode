package wiggleSort;

// LeetCode #280

// Given an unsorted array nums, reorder it in-place such that 
// nums[0] <= nums[1] >= nums[2] <= nums[3]....

public class WiggleSort {

	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0 && nums[i] > nums[i + 1]) {
				swap(nums, i, i + 1);
			} else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
				swap(nums, i, i + 1);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

package wiggleSort;

// LeetCode #280 (Wiggle Sort).

// Given an unsorted array nums, reorder it in-place such that 
// nums[0] <= nums[1] >= nums[2] <= nums[3] >= ...

public class WiggleSort {

	// one pass linear time
	public void wiggleSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if ((i % 2 == 0 && array[i] > array[i + 1]) || (i % 2 == 1 && array[i] < array[i + 1])) {
				swap(array, i, i + 1);
			}
		}
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Follow up: LeetCode #324 (Wiggle Sort).
	// Reorder it in-place such that nums[0] < nums[1] > nums[2] < nums[3] > ...
}

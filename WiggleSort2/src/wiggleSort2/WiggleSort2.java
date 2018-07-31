package wiggleSort2;

// LeetCode #324 (Wiggle Sort II).

// Given an unsorted array nums, reorder it such that 
// nums[0] < nums[1] > nums[2] < nums[3]....

public class WiggleSort2 {

	public void wiggleSort(int[] nums) {
		int median = select(nums, nums.length / 2);
		int i = 0, j = 0, k = nums.length - 1;
		while (j <= k) {
			// LeetCode #75 (Sort Colors) / rainbow sort 
			if (nums[newIndex(j, nums.length)] > median) {
				swap(nums, newIndex(i++, nums.length), newIndex(j++, nums.length));
			} else if (nums[newIndex(i, nums.length)] == median) {
				j++;
			} else {
				swap(nums, newIndex(i, nums.length), newIndex(k--, nums.length));
			}
		}
	}

	private int newIndex(int index, int n) {
		// (n | 1) is the nearest odd number that is no less than n
		return (1 + 2 * index) % (n | 1);
	}

	// k-th smallest element in array
	public int select(int[] array, int k) {
		int low = 0, high = array.length - 1;
		while (low < high) {
			int j = partition(array, low, high);
			if (j < k) {
				low = j + 1;
			} else if (j > k) {
				high = j - 1;
			} else {
				return array[k];
			}
		}
		return array[k];
	}

	private int partition(int[] array, int left, int right) {
		// randomly select a pivot position
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivot = array[pivotIndex];
		// swap the pivot element to the rightmost position
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

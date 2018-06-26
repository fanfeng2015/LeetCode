package threeSumSmaller;

import java.util.Arrays;

// LeetCode #259 (3 Sum Smaller).

// Given an array of n integers nums and a target, find the number of index triplets i, j, k 
// with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// Two Sum Smaller
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] < target) {
					count += (right - left);
					left++;
				} else {
					right--;
				}
			}
		}
		return count;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}

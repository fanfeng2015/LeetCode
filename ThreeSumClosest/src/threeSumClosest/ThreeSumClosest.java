package threeSumClosest;

import java.util.Arrays;

// LeetCode #16

// Given an array S of n integers, find three integers in S such that 
// the sum is closest to a given number, target. 
// Return the sum of the three integers. You may assume that each input 
// would have exactly one solution.

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int result = 0;
		if (nums.length <= 3) {
			for (int i : nums) {
				result += i;
			}
			return result;
		}
		Arrays.sort(nums);
		result = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1), if sorting is in-place.
}
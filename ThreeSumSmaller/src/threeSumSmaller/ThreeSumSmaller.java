package threeSumSmaller;

import java.util.Arrays;

// LeetCode #259

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// run TwoSumSmaller
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
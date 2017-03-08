package candy;

import java.util.Arrays;

// LeetCode #135

public class Candy {

	// Solution 1
	public int candy(int[] ratings) {
		int[] nums = new int[ratings.length];
		Arrays.fill(nums, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				nums[i] = Math.max(nums[i], nums[i + 1] + 1);
			}
		}
		int result = 0;
		for (int num : nums) {
			result += num;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: one pass
	public int candy2(int[] ratings) {
		int prev = 1, countDown = 0, result = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] >= ratings[i - 1]) {
				if (countDown > 0) {
					result += countDown * (countDown + 1) / 2;
					result += countDown >= prev ? countDown - prev + 1 : 0;
					prev = 1;
					countDown = 0;
				}
				prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
				result += prev;
			} else {
				countDown++;
			}
		}
		// post-processing
		if (countDown > 0) {
			result += countDown * (countDown + 1) / 2;
			result += countDown >= prev ? countDown - prev + 1 : 0;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

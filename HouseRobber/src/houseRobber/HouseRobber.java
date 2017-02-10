package houseRobber;

// LeetCode #198

// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed, the only constraint 
// stopping you from robbing each of them is that adjacent houses have 
// security system connected and it will automatically contact the police 
// if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class HouseRobber {

	// Solution 1
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] M = new int[nums.length];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			M[i] = nums[i];
			for (int j = 0; j < i - 1; j++) {
				M[i] = Math.max(M[i], M[j] + nums[i]);
			}
			result = Math.max(result, M[i]);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// Solution 2: Optimization
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int odd = 0, even = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				even = Math.max(even + nums[i], odd);
			} else {
				odd = Math.max(odd + nums[i], even);
			}
		}
		return Math.max(odd, even);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
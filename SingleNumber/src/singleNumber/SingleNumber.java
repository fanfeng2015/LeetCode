package singleNumber;

// LeetCode #136

// Given an array of integers, every element appears twice except for one. Find that single one.

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int mask = 0;
		for (int i : nums) {
			mask ^= i;
		}
		return mask;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

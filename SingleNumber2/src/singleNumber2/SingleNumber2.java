package singleNumber2;

// LeetCode #137

// Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

public class SingleNumber2 {

	public int singleNumber(int[] nums) {
		int one = 0, two = 0;
		for (int i : nums) {
			one = (one ^ i) & ~two;
			two = (two ^ i) & ~one;
		}
		return one;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

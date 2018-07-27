package singleNumber2;

// LeetCode #137 (Single Number II).

// Given an array of integers, every element appears three times except for one, which
// appears exactly once. Find that single one.

public class SingleNumber2 {

	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int i : nums) {
			ones = (ones ^ i) & ~twos;
			twos = (twos ^ i) & ~ones;
		}
		return ones;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

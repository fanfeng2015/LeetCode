package singleNumber2;

// LeetCode #137

// Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

public class SingleNumber2 {

	public int singleNumber(int[] nums) {
		// use two bits to count the total number of bits that are 1 (00, 01,
		// 10), ones keep all first bits of them, twos keep all second bits of
		// them
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

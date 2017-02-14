package singleNumber3;

// LeetCode #260

// Given an array of numbers nums, in which exactly two elements appear only once 
// and all the other elements appear exactly twice. 
// Find the two elements that appear only once.

public class SingleNumber3 {

	public int[] singleNumber(int[] nums) {
		// first pass
		int diff = 0;
		for (int i : nums) {
			diff ^= i;
		}
		// get the least significant bit that is 1
		diff &= ~(diff - 1);
		int[] result = new int[] { 0, 0 };
		// second pass: the two single numbers are in two different groups
		for (int i : nums) {
			if ((i & diff) == 0) {
				result[0] ^= i;
			} else {
				result[1] ^= i;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

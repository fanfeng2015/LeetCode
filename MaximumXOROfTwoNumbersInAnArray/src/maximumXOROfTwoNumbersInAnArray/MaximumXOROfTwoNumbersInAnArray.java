package maximumXOROfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

// LeetCode #421

public class MaximumXOROfTwoNumbersInAnArray {

	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask |= (1 << i);
			Set<Integer> set = new HashSet<Integer>();
			for (int num : nums) {
				set.add(num & mask); // only keep bits that are to the left of i
			}
			// we want to check if there exist two numbers,
			// such that XOR of their i-th bit evaluates to 1
			// fact: if a ^ b = c, then a ^ c = b && b ^ c = a
			int target = max | (1 << i);
			for (int num : set) {
				if (set.contains(target ^ num)) {
					max = target; // find such a pair, break
					break;
				}
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
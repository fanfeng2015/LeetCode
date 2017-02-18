package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

// LeetCode #179

// Given a list of non negative integers, arrange them such that they form the largest number.

public class LargestNumber {

	public String largestNumber(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String one, String two) {
				return (one + two).compareTo(two + one);
			}
		});
		if (strings[strings.length - 1].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			sb.append(strings[i]);
		}
		return sb.toString();
	}

	// Time complexity is
	// O(n * log(n)) + O(k + 2*k + ... + n*k) = O(n * log(n)) + O(n^2 * k).
	// Space complexity is O(n), because Java uses merge sort for Object types.
}

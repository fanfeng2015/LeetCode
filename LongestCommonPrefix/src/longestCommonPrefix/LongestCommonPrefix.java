package longestCommonPrefix;

import java.util.Arrays;

// LeetCode #14

// Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix {

	// Solution 1: find the shortest String, and check for existence of each
	// of its character in all other words
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// find the shortest String
		int index = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < min) {
				min = strs[i].length();
				index = i;
			}
		}
		String shortest = strs[index];
		for (index = 0; index < shortest.length(); index++) {
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(index) != shortest.charAt(index)) {
					return shortest.substring(0, index);
				}
			}
		}
		return shortest;
	}

	// Time complexity is O(n * k).
	// Space complexity is O(1).

	// Solution 2: sort first, then check for common prefix of the first and
	// last String
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs);
		char[] first = strs[0].toCharArray();
		char[] last = strs[strs.length - 1].toCharArray();
		int index = 0;
		while (index < first.length && index < last.length && first[index] == last[index]) {
			index++;
		}
		return strs[0].substring(0, index);
	}

	// Time complexity is O(n * log(n)).
	// Space complexity is O(k).
}
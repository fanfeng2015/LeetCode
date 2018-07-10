package permutationInString;

// LeetCode #567 (Permutation in String).

// Given two strings s1 and s2, write a function to return true if s2 contains 
// the permutation of s1. In other words, one of the first string's permutations
// is the substring of the second string.

// Note:
// 1. The input strings only contain lower case letters.
// 2. The length of both given strings is in range [1, 10,000].

public class PermutationInString {

	private static final int NUM_LETTERS = 26;

	public boolean checkInclusion(String s1, String s2) {
		int[] countMap = new int[NUM_LETTERS];
		for (int i = 0; i < s1.length(); i++) {
			countMap[s1.charAt(i) - 'a']++;
		}
		int count = s1.length();
		int left = 0, right = 0;
		while (right < s2.length()) {
			if (right - left == s1.length() && countMap[s2.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
			if (countMap[s2.charAt(right++) - 'a']-- > 0) {
				count--;
			}
			if (count == 0) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}

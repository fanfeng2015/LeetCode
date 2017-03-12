package longestSubstringWithAtLeastKRepeatingCharacters;

// LeetCode #395

// Find the length of the longest substring T of a given string (consists of lower-case letters only) 
// such that every character in T appears no less than k times.

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
		return longestSubstring(s, k, 0, s.length() - 1);
	}

	private int longestSubstring(String s, int k, int left, int right) {
		// base case
		if (right - left + 1 < k) {
			return 0;
		}
		int[] count = new int[26];
		for (int i = left; i <= right; i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			// if a character exists in this current substring from left to
			// right, but has count < k, then we know:
			// 1. this current substring is not valid;
			// 2. some substring of this current substring might be valid, but
			// it doesn't contain this character for sure.
			if (0 < count[i] && count[i] < k) {
				for (int j = left; j <= right; j++) {
					if (s.charAt(j) == 'a' + i) {
						return Math.max(longestSubstring(s, k, left, j - 1), longestSubstring(s, k, j + 1, right));
					}
				}
			}
		}
		// up to this point, every character has count < 0 or >= k
		return right - left + 1;
	}

	// Time complexity is O(n^2). Worst could be s = "abcdefg", k = 2.
	// Space complexity is O(n), because of call-stack.
}

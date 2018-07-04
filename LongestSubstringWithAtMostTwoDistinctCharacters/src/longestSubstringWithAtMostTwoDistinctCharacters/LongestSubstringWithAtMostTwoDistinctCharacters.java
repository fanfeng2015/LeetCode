package longestSubstringWithAtMostTwoDistinctCharacters;

// LeetCode #159 (Longest Substring with At Most Two Distinct Characters).

// Given a string s , find the length of the longest substring t  that contains 
// at most 2 distinct characters.

public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0, lo = 0;
		Entity one = null, two = null;
		for (int i = 0; i < s.length(); i++) {
			if (one == null) {
				one = new Entity(s.charAt(i), i);
			} else if (s.charAt(i) == one.ch) {
				one.lastOccurrence = i;
			} else if (two == null) {
				two = new Entity(s.charAt(i), i);
			} else if (s.charAt(i) == two.ch) {
				two.lastOccurrence = i;
			} else if (one.lastOccurrence < two.lastOccurrence) {
				lo = one.lastOccurrence + 1;
				one = new Entity(s.charAt(i), i);
			} else {
				lo = two.lastOccurrence + 1;
				two = new Entity(s.charAt(i), i);
			}
			max = Math.max(max, i - lo + 1);
		}
		return max;
	}

	private static class Entity {
		char ch;
		int lastOccurrence;

		Entity(char ch, int lastOccurrence) {
			this.ch = ch;
			this.lastOccurrence = lastOccurrence;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

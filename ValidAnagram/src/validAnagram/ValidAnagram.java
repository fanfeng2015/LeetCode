package validAnagram;

// LeetCode #242
// Given two strings s and t, write a function to determine if t is an anagram of s.
// Assumption: String s and t contain only lower-case letters.

public class ValidAnagram {

	private int length = 26;

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] count = new int[length];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

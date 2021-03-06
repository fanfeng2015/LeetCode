package isomorphicStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LeetCode #205

// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while 
// preserving the order of characters. No two characters may map to the same character
// but a character may map to itself.

public class IsomorphicStrings {

	// Solution 1: use 2 hash maps, one maps s to t, the other maps t to s
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> st = new HashMap<>();
		Map<Character, Character> ts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character charT = st.get(s.charAt(i));
			Character charS = ts.get(t.charAt(i));
			if (charT == null && charS == null) {
				st.put(s.charAt(i), t.charAt(i));
				ts.put(t.charAt(i), s.charAt(i));
			} else if (charT != null && charS != null && charT == t.charAt(i) && charS == s.charAt(i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n). However, because there are only certain number
	// of possible characters (256 for ASCII), solution 1 is no worse than
	// solution 2 in terms of complexity.

	// Solution 2
	public boolean isIsomorphic2(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] a = new int[256];
		int[] b = new int[256];
		Arrays.fill(a, -1);
		Arrays.fill(b, -1);
		for (int i = 0; i < s.length(); i++) {
			if (a[(int) s.charAt(i)] != b[(int) t.charAt(i)]) {
				return false;
			}
			a[(int) s.charAt(i)] = i;
			b[(int) t.charAt(i)] = i;
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

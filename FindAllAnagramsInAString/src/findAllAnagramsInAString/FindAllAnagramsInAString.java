package findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

// LeetCode #438 (Find All Anagrams in a String).

// Given a string s and a non-empty string p, find all the start indices of p's 
// anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings
// s and p will not be larger than 20,100.

// The order of output does not matter.

public class FindAllAnagramsInAString {

	private static final int NUM_LETTERS = 26;

	public List<Integer> findAnagrams(String s, String p) {
		int[] countMap = new int[NUM_LETTERS];
		for (int i = 0; i < p.length(); i++) {
			countMap[p.charAt(i) - 'a']++;
		}
		int left = 0, right = 0;
		int count = p.length(); // number of chars in p
		List<Integer> result = new ArrayList<>();
		while (right < s.length()) {
			if (right - left == p.length() && countMap[s.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
			if (countMap[s.charAt(right++) - 'a']-- > 0) {
				count--;
			}
			if (count == 0) {
				result.add(left);
			}
		}
		return result;
	}

}

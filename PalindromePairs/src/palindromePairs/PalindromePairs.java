package palindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #336 (Palindrome Pairs).

// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that
// the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

public class PalindromePairs {

	// Solution 1: O(n^2 * k).

	// Solution 2: O(n * k^2)
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String left = words[i].substring(0, j);
				String right = words[i].substring(j);
				if (isPalindrome(left)) {
					String reverseRight = new StringBuilder(right).reverse().toString();
					if (map.containsKey(reverseRight) && map.get(reverseRight) != i) {
						result.add(Arrays.asList(new Integer[] { map.get(reverseRight), i }));
					}
				}
				if (isPalindrome(right)) {
					String reverseLeft = new StringBuilder(left).reverse().toString();
					if (map.containsKey(reverseLeft) && map.get(reverseLeft) != i && right.length() != 0) { // note
						result.add(Arrays.asList(new Integer[] { i, map.get(reverseLeft) }));
					}
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left++) != str.charAt(right--)) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n * k^2).
	// Space complexity is O(n).
}

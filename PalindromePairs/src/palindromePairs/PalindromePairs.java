package palindromePairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #336

// Given a list of unique words, find all pairs of distinct indices (i, j) 
// in the given list, so that the concatenation of the two words, i.e. words[i] + words[j]
// is a palindrome.

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
				String firstHalf = words[i].substring(0, j);
				String secondHalf = words[i].substring(j);
				if (isPalindrome(firstHalf)) {
					String reverseSecondHalf = new StringBuilder(secondHalf).reverse().toString();
					if (map.containsKey(reverseSecondHalf) && map.get(reverseSecondHalf) != i) {
						List<Integer> cur = new ArrayList<>();
						cur.add(map.get(reverseSecondHalf));
						cur.add(i);
						result.add(cur);
					}
				}
				if (isPalindrome(secondHalf)) {
					String reverseFirstHalf = new StringBuilder(firstHalf).reverse().toString();
					if (map.containsKey(reverseFirstHalf) && map.get(reverseFirstHalf) != i
							&& secondHalf.length() != 0) {
						List<Integer> cur = new ArrayList<>();
						cur.add(i);
						cur.add(map.get(reverseFirstHalf));
						result.add(cur);
					}
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// Time complexity is O(n * k^2).
	// Space complexity is O(n).
}
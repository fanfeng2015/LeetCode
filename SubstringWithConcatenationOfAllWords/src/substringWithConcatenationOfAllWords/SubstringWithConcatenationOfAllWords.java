package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #30

// You are given a string, s, and a list of words, words, 
// that are all of the same length. 
// Find all starting indices of substring(s) in s that is a 
// concatenation of each word in words exactly once and without
// any intervening characters.

public class SubstringWithConcatenationOfAllWords {

	// Solution 1
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int m = s.length(), n = words.length, k = words[0].length();
		if (m < n * k) {
			return result;
		}
		// there could be duplicate words
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer count = map.get(word);
			count = count == null ? 1 : count + 1;
			map.put(word, count);
		}
		for (int i = 0; i <= m - n * k; i++) {
			Map<String, Integer> copy = new HashMap<>(map);
			if (isConcatenationOfAllWords(copy, s.substring(i, i + n * k), words)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean isConcatenationOfAllWords(Map<String, Integer> map, String substring, String[] words) {
		int n = words.length, k = words[0].length();
		for (int i = 0; i < n; i++) {
			String str = substring.substring(i * k, (i + 1) * k);
			Integer count = map.get(str);
			if (count == null || count == 0) {
				return false;
			} else {
				map.put(str, count - 1);
			}
		}
		return true; // always return true if this point is reached
	}

	// Time complexity is O(m*n*k).
	// Space complexity is O(n).

	// Solution 2: optimize time complexity?

}

package wordBreak2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #140 (Word Break II).

// Given a non-empty string s and a dictionary wordDict containing a list of 
// non-empty words, add spaces in s to construct a sentence where each word is
// a valid dictionary word. Return all such possible sentences.

// Assumptions:
// 1. The same word in the dictionary may be reused multiple times in the segmentation.
// 2. You may assume the dictionary does not contain duplicate words.

public class WordBreak2 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		if (!canBreak(s, wordDict)) {
			return new ArrayList<String>();
		}
		StringBuilder sb = new StringBuilder();
		List<String> cur = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		Set<String> set = new HashSet<>(wordDict);
		DFS(s, set, sb, cur, result);
		return result;
	}

	private void DFS(String s, Set<String> set, StringBuilder sb, List<String> cur, List<String> result) {
		if (sb.toString().equals(s)) {
			result.add(String.join(" ", cur));
			return;
		}
		if (!s.startsWith(sb.toString()) || sb.length() > s.length()) { // optimization
			return;
		}
		for (String str : set) {
			int len = sb.length();
			sb.append(str);
			cur.add(str);
			DFS(s, set, sb, cur, result);
			sb.delete(len, sb.length());
			cur.remove(cur.size() - 2);
		}
	}

	// LeetCode #139 (Word Break). Necessary to avoid TLE.
	public boolean canBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (canBreak[j] && set.contains(s.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[s.length()];
	}
	
	// Let m be the length of String s, and n be the size of the dictionary.
	// Time complexity is O(n + m^3 + n^m) = O(m^3 + n^m).
	// Space complexity is O(n + m).
}

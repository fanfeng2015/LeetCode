package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

// LeetCode #131

// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.

// For example, given s = "aab", return [ ["aa", "b"], ["a", "a", "b"] ]

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		// first, build table M
		boolean[][] M = isPalindrome(s);
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<>();
		DFS(s, M, result, cur, 0);
		return result;
	}

	// M[i][j]: whether substring from i to j, inclusive, is a palindrome
	private boolean[][] isPalindrome(String s) {
		int n = s.length();
		boolean[][] M = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j <= n - 1; j++) {
				if (i == j || (i == j - 1 && s.charAt(i) == s.charAt(j))
						|| (i < j - 1 && s.charAt(i) == s.charAt(j) && M[i + 1][j - 1])) {
					M[i][j] = true;
				}
			}
		}
		return M;
	}

	private void DFS(String s, boolean[][] M, List<List<String>> result, List<String> cur, int left) {
		int n = s.length();
		// base case
		if (left >= n) {
			result.add(new ArrayList<String>(cur));
			return;
		}
		// recursive rule
		for (int j = left; j < n; j++) {
			if (M[left][j]) {
				cur.add(s.substring(left, j + 1));
				DFS(s, M, result, cur, j + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}

	// Time complexity is O(n^2) + O(2^n)?
	// Space complexity is O(n^2).
}
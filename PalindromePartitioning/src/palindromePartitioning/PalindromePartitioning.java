package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

// LeetCode #131 (Palindrome Partitioning).

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab", return [ ["aa", "b"], ["a", "a", "b"] ]

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		boolean[][] isPalindrome = isPalindrome(s); // build boolean matrix
		List<String> cur = new ArrayList<>();
		List<List<String>> result = new ArrayList<List<String>>();
		DFS(s, isPalindrome, 0, cur, result);
		return result;
	}

	// M[i][j]: whether substring in [i, j] is a palindrome
	private boolean[][] isPalindrome(String s) {
		int n = s.length();
		boolean[][] M = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j <= n - 1; j++) {
				M[i][j] = (i == j) || (i == j - 1 && s.charAt(i) == s.charAt(j))
						|| (i < j - 1 && s.charAt(i) == s.charAt(j) && M[i + 1][j - 1]);
			}
		}
		return M;
	}

	private void DFS(String s, boolean[][] isPalindrome, int left, List<String> cur, List<List<String>> result) {
		if (left == s.length()) {
			result.add(new ArrayList<String>(cur));
			return;
		}
		for (int j = left; j < s.length(); j++) {
			if (isPalindrome[left][j]) {
				cur.add(s.substring(left, j + 1));
				DFS(s, isPalindrome, j + 1, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	// Time complexity is O(n^2) + O(n^n).
	// Space complexity is O(n^2).

	// Follow up :
	// LeetCode #132 (Palindrome Partitioning II) / Minimum Cuts for Palindromes.
}

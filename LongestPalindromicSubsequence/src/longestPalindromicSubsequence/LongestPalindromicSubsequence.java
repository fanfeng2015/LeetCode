package longestPalindromicSubsequence;

// LeetCode #516

// Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

public class LongestPalindromicSubsequence {

	// M[i][j]: length of the longest palindromic subsequence in substring from
	// i to j, inclusive
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] M = new int[n][n];
		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j <= n - 1; j++) {
				if (i == j) {
					M[i][j] = 1;
				} else if (s.charAt(i) == s.charAt(j)) {
					// fine even if i + 1 > j - 1, because cells in the
					// bottom-left triangle are all zero
					M[i][j] = M[i + 1][j - 1] + 2;
				} else if (s.charAt(i) != s.charAt(j)) {
					M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);
				}
				max = Math.max(max, M[i][j]);
			}
		}
		return max;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2), although we really only need O(n).
}

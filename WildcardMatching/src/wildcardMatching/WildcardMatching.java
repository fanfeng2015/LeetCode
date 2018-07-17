package wildcardMatching;

// LeetCode #44 (Wildcard Matching).

// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// s could be empty and contains only lowercase letters a-z.
// p could be empty and contains only lowercase letters a-z, and characters like ? or *.

public class WildcardMatching {

	// M[i][j]: whether s[0, ..., i - 1] can be matched by p[0, ..., j - 1]
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] M = new boolean[m + 1][n + 1];
		M[0][0] = true;
		for (int j = 1; j <= n; j++) {
			M[0][j] = (p.charAt(j - 1) == '*') && M[0][j - 1];
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					for (int k = 0; k <= i; k++) {
						M[i][j] |= M[i - k][j - 1];
					}
				}
			}
		}
		return M[m][n];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(m).
}

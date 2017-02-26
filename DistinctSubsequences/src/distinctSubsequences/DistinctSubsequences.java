package distinctSubsequences;

// LeetCode #115

// Given a string S and a string T, count the number of distinct subsequences of T in S.

public class DistinctSubsequences {

	public int numDistinct(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] M = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			M[i][0] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= Math.min(i, n); j++) {
				M[i][j] = M[i - 1][j];
				M[i][j] += s.charAt(i - 1) == t.charAt(j - 1) ? M[i - 1][j - 1] : 0;
			}
		}
		return M[m][n];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

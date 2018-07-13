package perfectSquares;

import java.util.Arrays;

// LeetCode #279 (Perfect Squares).

// Given a positive integer n, find the least number of perfect square numbers 
// (for example, 1, 4, 9, 16, ...) which sum to n.

public class PerfectSquares {

	public int numSquares(int n) {
		int[] M = new int[n + 1];
		Arrays.fill(M, Integer.MAX_VALUE);
		M[0] = 0;
		for (int i = 1; i <= n; i++) {
			int j = 1;
			while (i - j * j >= 0) {
				M[i] = Math.min(M[i], M[i - j * j] + 1);
				j++;
			}
		}
		return M[n];
	}

	// Time complexity is O(1 + sqrt(2) + sqrt(3) + ... + sqrt(n)).
	// Space complexity is O(n).
}

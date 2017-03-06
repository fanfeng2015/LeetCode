package minimumPathSum;

// LeetCode #64

// Given a m x n grid filled with non-negative numbers, 
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] M = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1) {
					M[i][j] = grid[i][j] + (j == n - 1 ? 0 : M[i][j + 1]);
				} else {
					M[i][j] = grid[i][j] + (j == n - 1 ? M[i + 1][j] : Math.min(M[i + 1][j], M[i][j + 1]));
				}
			}
		}
		return M[0][0];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but we really only need O(n).
}
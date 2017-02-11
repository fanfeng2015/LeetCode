package uniquePaths2;

// LeetCode #63: follow-up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths could there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

public class UniquePaths2 {

	private int count = 0;

	// Solution 1: DFS
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		DFS(obstacleGrid, 0, 0);
		return count;
	}

	private void DFS(int[][] obstacleGrid, int row, int col) {
		// base case
		if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
			count++;
			return;
		}
		// row < obstacleGrid.length - 1 || col < obstacleGrid[0].length - 1
		if (row < obstacleGrid.length - 1 && obstacleGrid[row + 1][col] != 1) {
			DFS(obstacleGrid, row + 1, col);
		}
		if (col < obstacleGrid[0].length - 1 && obstacleGrid[row][col + 1] != 1) {
			DFS(obstacleGrid, row, col + 1);
		}
	}

	// Time complexity is O(2^(m+n)).
	// Space complexity is O(m+n).

	// Solution 2: DP
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] M = new int[m][n];
		M[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if ((i != m - 1 || j != n - 1) && obstacleGrid[i][j] != 1) {
					M[i][j] = ((i < m - 1) ? M[i + 1][j] : 0) + ((j < n - 1) ? M[i][j + 1] : 0);
				}
			}
		}
		return M[0][0];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but we really only need O(n).
}

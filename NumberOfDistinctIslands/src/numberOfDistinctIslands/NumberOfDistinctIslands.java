package numberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

// LeetCode #694 (Number of Distinct Islands).

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid 
// are surrounded by water.

// Count the number of distinct islands.An island is considered to be the same as another if and 
// only if one island can be translated(and not rotated or reflected)to equal the other.

public class NumberOfDistinctIslands {

	private int startRow = 0, startCol = 0;
	private int count = 0;
	private int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numDistinctIslands(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
					StringBuilder sb = new StringBuilder();
					DFS(grid, i, j, sb, set);
					if (set.add(sb.toString())) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private void DFS(int[][] grid, int i, int j, StringBuilder sb, Set<String> set) {
		int m = grid.length, n = grid[0].length;
		if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
			grid[i][j] = 0;
			sb.append(i - startRow).append(j - startCol);
			for (int[] direction : directions) {
				DFS(grid, i + direction[0], j + direction[1], sb, set);
			}
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call-stack.
}

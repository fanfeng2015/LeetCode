package numberOfIslands;

// LeetCode #200 (Number of Islands).

// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally
// or vertically. 

// You may assume all four edges of the grid are all surrounded by water.

public class NumberOfIslands {

	// Solution 1: DFS
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
			return;
		}
		grid[row][col] = '0';
		DFS(grid, row - 1, col);
		DFS(grid, row + 1, col);
		DFS(grid, row, col - 1);
		DFS(grid, row, col + 1);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call-stack.
	
	// Solution 2: Union Find
	private int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	
	public int numIslands2(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		UnionFind unionFind = new UnionFind(grid);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					for (int[] direction : directions) {
						int row = i + direction[0];
						int col = j + direction[1];
						if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
							unionFind.union(i * n + j, row * n + col);
						}
					}
				}
			}
		}
		return unionFind.count();
	}
	
	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n), but on heap instead of stack.
	
	// Follow up: LeetCode #305 (Number of Islands II).
}

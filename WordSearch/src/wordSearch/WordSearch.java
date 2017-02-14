package wordSearch;

// LeetCode #79

// Given a 2D board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cell, 
// where "adjacent" cells are those horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

public class WordSearch {

	private static int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] visited = new boolean[m][n];
					visited[i][j] = true;
					if (DFS(board, word, i, j, 1, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int row, int col, int pos, boolean[][] visited) {
		// base case
		if (pos == word.length()) {
			return true;
		}
		for (int[] direction : directions) {
			if (0 <= row + direction[0] && row + direction[0] <= board.length - 1 && 0 <= col + direction[1]
					&& col + direction[1] <= board[0].length - 1
					&& board[row + direction[0]][col + direction[1]] == word.charAt(pos)
					&& !visited[row + direction[0]][col + direction[1]]) {
				visited[row + direction[0]][col + direction[1]] = true;
				if (DFS(board, word, row + direction[0], col + direction[1], pos + 1, visited)) {
					return true;
				} else {
					visited[row + direction[0]][col + direction[1]] = false;
				}
			}
		}
		return false;
	}

	// Time complexity is O(m*n * 4^(m*n))?
	// Space complexity is O(m*n)?
}
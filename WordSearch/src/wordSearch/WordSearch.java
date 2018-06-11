package wordSearch;

// LeetCode #79 (Word Search).

// Given a 2D board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cell, 
// where "adjacent" cells are those horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

public class WordSearch {

	private static int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] visited = new boolean[m][n];
					visited[i][j] = true;
					if (DFS(board, word, 1, i, j, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
		if (start == word.length()) {
			return true;
		}
		for (int[] direction : directions) {
			int newRow = row + direction[0], newCol = col + direction[1];
			if (newRow >= 0 && newRow < board.length 
				&& newCol >= 0 && newCol < board[0].length
				&& board[newRow][newCol] == word.charAt(start)
				&& !visited[row + direction[0]][col + direction[1]]) 
			{
				visited[newRow][newCol] = true;
				if (DFS(board, word, start + 1, newRow, newCol, visited)) {
					return true;
				}
				visited[newRow][newCol] = false;
			}
		}
		return false;
	}

	// Time complexity is O(m*n * 4^(m*n)).
	// Space complexity is O(m*n)?
}

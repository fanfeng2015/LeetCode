package surroundedRegions;

// LeetCode #130 (Surrounded Regions).

// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

public class SurroundedRegions {

	// change all 'O' touching the border to '#', then change all 'O' to 'X',
	// finally change all '#' to 'O'
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length, n = board[0].length;
		// change the first and last column
		for (int i = 0; i < m; i++) {
			DFS(board, i, 0);
			DFS(board, i, n - 1);
		}
		// change the first and last row
		for (int i = 0; i < n; i++) {
			DFS(board, 0, i);
			DFS(board, m - 1, i);
		}
		// change all 'O' to 'X' and all '#' to 'O'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] == 'O' ? 'X' : board[i][j] == '#' ? 'O' : board[i][j];
			}
		}
	}

	private void DFS(char[][] board, int i, int j) {
		int m = board.length, n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		if (board[i][j] == 'O') {
			board[i][j] = '#';
			DFS(board, i - 1, j);
			DFS(board, i, j + 1);
			DFS(board, i + 1, j);
			DFS(board, i, j - 1);
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call-stack.
}

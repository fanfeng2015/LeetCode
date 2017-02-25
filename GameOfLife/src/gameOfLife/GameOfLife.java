package gameOfLife;

// LeetCode #289

public class GameOfLife {

	int[][] directions = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	public void gameOfLife(int[][] board) {
		int m = board.length, n = board[0].length;
		int[][] M = copy(board);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int[] dir : directions) {
					int row = i + dir[0], col = j + dir[1];
					if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1) {
						count = M[row][col] == 1 ? count + 1 : count;
					}
				}
				if (M[i][j] == 0) {
					board[i][j] = count == 3 ? 1 : 0;
				} else if (M[i][j] == 1) {
					board[i][j] = count == 2 || count == 3 ? 1 : 0;
				}
			}
		}
	}

	private int[][] copy(int[][] board) {
		int m = board.length, n = board[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = board[i][j];
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	// Follow-up: Could you solve it in-place?
	// Answer: Use the second least bit to store the next state,
	// In the first pass, compute the next state; in the second pass, shift all
	// values to the right by one bit.

}

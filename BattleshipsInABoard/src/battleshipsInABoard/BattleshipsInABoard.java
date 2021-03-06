package battleshipsInABoard;

// LeetCode #419

// Given an 2D board, count how many battleships are in it. 
// The battleships are represented with 'X's, empty slots are represented with '.'s. 
// You may assume the following rules:

// 1. You receive a valid board, made of only battleships or empty slots.
// 2. Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
// 3. At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

public class BattleshipsInABoard {

	private int count;

	public int countBattleships(char[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					count++;
					DFS(board, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] board, int i, int j) {
		board[i][j] = '.';
		if (i > 0 && board[i - 1][j] == 'X') {
			DFS(board, i - 1, j);
		}
		if (i < board.length - 1 && board[i + 1][j] == 'X') {
			DFS(board, i + 1, j);
		}
		if (j > 0 && board[i][j - 1] == 'X') {
			DFS(board, i, j - 1);
		}
		if (j < board[0].length - 1 && board[i][j + 1] == 'X') {
			DFS(board, i, j + 1);
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1), although the input matrix is modified.

	// follow-up: could you do it in one-pass, using O(1) extra space, and not
	// modify the original input matrix
	public int countBattleships2(char[][] board) {
		int m = board.length, n = board[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
					count++;
				}
			}
		}
		return count;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).
}

package sudokuSolver;

// LeetCode #37 (Sudoku Solver).

// Write a program to solve a Sudoku puzzle by filling the empty cells.

// Empty cells are indicated by the character '.'.

// You may assume that there will be only one unique solution.

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		DFS(board);
	}

	private boolean DFS(char[][] board) {
		int n = board.length; // 9
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') { // once the first '.' is found, true/false is always returned
					for (char ch = '1'; ch <= '9'; ch++) {
						if (valid(board, i, j, ch)) {
							board[i][j] = ch;
							if (DFS(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean valid(char[][] board, int i, int j, char ch) {
		for (int k = 0; k < board.length; k++) {
			if (board[i][k] == ch || board[k][j] == ch || board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == ch) {
				return false;
			}
		}
		return true;
	}

}

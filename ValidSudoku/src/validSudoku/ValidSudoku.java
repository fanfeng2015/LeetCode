package validSudoku;

// LeetCode #36

// Determine if a Sudoku is valid.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		int m = board.length, n = board[0].length; // both are 9
		boolean[][] rows = new boolean[m][n], cols = new boolean[m][n], blocks = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int k = (i / 3) * 3 + j / 3;
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]) - 1;
					if (rows[i][num] || cols[j][num] || blocks[k][num]) {
						return false;
					}
					rows[i][num] = cols[j][num] = blocks[k][num] = true;
				}
			}
		}
		return true;
	}

}

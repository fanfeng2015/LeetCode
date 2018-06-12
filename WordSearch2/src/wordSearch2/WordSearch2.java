package wordSearch2;

import java.util.ArrayList;
import java.util.List;

// LeetCode #212 (Word Search II).

// Given a 2D board and a list of words from the dictionary, find all words in the board.
// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" 
// cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

public class WordSearch2 {

	// Obviously, LeetCode #79 (Word Search) solves the problem.

	// A better solution is to use Trie.
	private static int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {
		ImplementTrie impl = new ImplementTrie();
		for (String word : words) {
			impl.insert(word);
		}
		TrieNode root = impl.getRoot();

		int m = board.length, n = board[0].length;
		List<String> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] visited = new boolean[m][n];
				visited[i][j] = true;
				DFS(board, root, i, j, visited, result);
			}
		}
		return result;
	}

	private void DFS(char[][] board, TrieNode root, int row, int col, boolean[][] visited, List<String> result) {
		char ch = board[row][col];
		TrieNode next = root.children[ch - 'a'];
		if (next == null) {
			return;
		} else if (next.word != null) {
			result.add(next.word);
			next.word = null; // avoid duplicate
			// no return
		}
		for (int[] direction : directions) {
			int newRow = row + direction[0], newCol = col + direction[1];
			if (newRow >= 0 && newRow < board.length
				&& newCol >= 0 && newCol < board[0].length
				&& !visited[newRow][newCol])
			{
				visited[newRow][newCol] = true;
				DFS(board, next, newRow, newCol, visited, result);
				visited[newRow][newCol] = false;
			}
		}
	}
	
	// Building the Trie...
	// Time complexity is O(sum of string lengths).
	// Space complexity is O(sum of string lengths).
	
	// Time complexity is O(m*n * 4^(m*n)).
	// Space complexity is O(m*n).
}

package triangle;

import java.util.List;

// LeetCode #120

// Given a triangle, find the minimum path sum from top to bottom. 
// Each step you may move to adjacent numbers on the row below.

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] M = new int[n][n];
		M[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int prev = Math.min((j - 1 < 0 ? Integer.MAX_VALUE : M[i - 1][j - 1]),
						(j > i - 1 ? Integer.MAX_VALUE : M[i - 1][j]));
				M[i][j] = prev + triangle.get(i).get(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, M[n - 1][i]);
		}
		return min;
	}

	// Time complexity is O(n), where n is the total number of integers in the
	// triangle.
	// Space complexity is O(n), although one optimization is to use two
	// rotating one-dimensional arrays.
}

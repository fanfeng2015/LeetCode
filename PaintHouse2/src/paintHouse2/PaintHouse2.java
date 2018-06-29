package paintHouse2;

// LeetCode #265 (Paint House II).

// There are a row of n houses, each house can be painted with one of the k colors.

// The cost of painting each house with a certain color is different. You have to 
// paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x k 
// cost matrix.

// For example, costs[0][0] is the cost of painting house 0 with color 0, costs[1][2]
// is the cost of painting house 1 with color 2, and so on...

// Find the minimum cost to paint all houses.

public class PaintHouse2 {

	// Solution from LeetCode #256 (Paint House) costs O(n*k*k) time and O(k) space.

	// Optimal solution costs O(n*k) time and O(1) space.
	public int minCost(int[][] costs) {
		int n = costs.length, k = costs[0].length;
		int curMinIndex = -1, curSecondMinIndex = -1;
		for (int i = 0; i < n; i++) {
			int prevMinIndex = curMinIndex, prevSecondMinIndex = curSecondMinIndex;
			curMinIndex = curSecondMinIndex = -1;
			for (int j = 0; j < k; j++) {
				costs[i][j] += (i == 0) ? 0
						: (j == prevMinIndex) ? costs[i - 1][prevSecondMinIndex] : costs[i - 1][prevMinIndex];
				// update curMinIndex and curSecondMinIndex
				if (curMinIndex < 0 || costs[i][j] < costs[i][curMinIndex]) {
					curSecondMinIndex = curMinIndex;
					curMinIndex = j;
				} else if (curSecondMinIndex < 0 || costs[i][j] < costs[i][curSecondMinIndex]) { // else if, not if
					curSecondMinIndex = j;
				}
			}
		}
		return costs[n - 1][curMinIndex];
	}

	// Time complexity is O(n*k).
	// Space complexity is O(1).
}

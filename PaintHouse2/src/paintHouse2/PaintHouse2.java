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
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int n = costs.length, k = costs[0].length;
		int curMin = -1, curSecondMin = -1; // both are index
		for (int i = 0; i < n; i++) {
			int prevMin = curMin, prevSecondMin = curSecondMin;
			curMin = curSecondMin = -1;
			for (int j = 0; j < k; j++) {
				costs[i][j] += (i == 0) ? 0
						: (j == prevMin) ? costs[i - 1][prevSecondMin] : costs[i - 1][prevSecondMin];
				// update curMin and curSecondMin
				if (curMin < 0 || costs[i][j] < costs[i][curMin]) {
					curSecondMin = curMin;
					curMin = j;
				} else if (curSecondMin < 0 || costs[i][j] < costs[i][curSecondMin]) { // else if, not if
					curSecondMin = j;
				}
			}
		}
		return costs[n - 1][curMin];
	}

	// Time complexity is O(n*k).
	// Space complexity is O(1).
}

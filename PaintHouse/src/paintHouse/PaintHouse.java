package paintHouse;

// LeetCode #256

// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
// The cost of painting each house with a certain color is different. 
// You have to paint all the houses such that no two adjacent houses have the same color.
// Find the minimum cost to paint all houses.

public class PaintHouse {

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int n = costs.length;
		int[] prev = new int[3], cur = new int[3];
		prev = costs[0];
		for (int i = 1; i < n; i++) {
			cur = new int[3];
			for (int j = 0; j < 3; j++) {
				cur[j] = costs[i][j] + Math.min(prev[(j + 1) % 3], prev[(j + 2) % 3]);
			}
			prev = cur;
		}
		return Math.min(prev[0], Math.min(prev[1], prev[2]));
	}

	// Time complexity is O(n * k).
	// Space complexity is O(k).

}

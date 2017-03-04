package burstBalloons;

// LeetCode #312

// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
// You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
// Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

// Find the maximum coins you can collect by bursting the balloons wisely.

public class BurstBalloons {

	public int maxCoins(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums) {
			if (x > 0) {
				nums[n++] = x;
			}
		}
		nums[0] = nums[n++] = 1;
		int[][] M = new int[n][n];
		for (int k = 2; k < n; k++) {
			for (int left = 0; left < n - k; left++) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i)
					M[left][right] = Math.max(M[left][right],
							nums[left] * nums[i] * nums[right] + M[left][i] + M[i][right]);
			}
		}
		return M[0][n - 1];
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).
}

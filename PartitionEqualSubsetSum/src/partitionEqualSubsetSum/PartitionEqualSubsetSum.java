package partitionEqualSubsetSum;

import java.util.Arrays;

// LeetCode #416 (Partition Equal Subset Sum).

// Given a non-empty array containing only positive integers, find if the array can be
// partitioned into two subsets such that the sum of elements in both subsets is equal.

public class PartitionEqualSubsetSum {

	// Knapsack problem
	// M[i][j]: whether some numbers in nums in [0, i] can sum up to j
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1) {
			return false;
		}
		boolean[][] M = new boolean[n][sum + 1];
		M[0][nums[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= sum; j++) {
				M[i][j] = M[i - 1][j] || (j - nums[i] >= 0 && M[i - 1][j - nums[i]]);
			}
		}
		return M[n - 1][sum / 2];
	}

	// Time complexity is O(n*sum).
	// Space complexity is O(n*sum), but obviously can be optimized to O(sum).
}

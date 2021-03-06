package rotateFunction;

// LeetCode #396

// Given an array of integers A and let n be its length.
// Assume Bk to be an array obtained by rotating the array A 
// k positions clock-wise, we define a "rotation function" F on A as follows:
// F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
// Calculate the maximum value of F(0), F(1), ..., F(n-1).

public class RotateFunction {

	// F(k) - F(k-1) = (Bk[0] + ... + Bk[n-1]) - n * Bk[0]
	public int maxRotateFunction(int[] A) {
		int sum = 0, prev = 0, cur = 0;
		int n = A.length;
		for (int i = 0; i < A.length; i++) {
			cur += i * A[i];
			sum += A[i];
		}
		int max = cur;
		for (int i = 0; i < n; i++) {
			prev = cur;
			cur = prev + sum - n * A[n - i - 1];
			max = Math.max(max, cur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

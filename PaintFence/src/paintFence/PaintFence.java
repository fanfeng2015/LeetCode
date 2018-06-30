package paintFence;

// LeetCode #276 (Paint Fence).

// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts 
// have the same color.

// Return the total number of ways you can paint the fence.

public class PaintFence {

	public int numWays(int n, int k) {
		if (n == 0) {
			return 0;
		}
		int prevSame = 0, prevDiff = k;
		for (int i = 1; i < n; i++) {
			int curSame = prevDiff;
			int curDiff = (prevSame + prevDiff) * (k - 1);
			prevSame = curSame;
			prevDiff = curDiff;
		}
		return prevSame + prevDiff;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

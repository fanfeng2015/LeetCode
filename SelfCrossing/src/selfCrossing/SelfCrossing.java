package selfCrossing;

// LeetCode #335

// You are given an array x of n positive numbers. 
// You start at point (0,0) and moves x[0] meters to the north, 
// then x[1] meters to the west, x[2] meters to the south, 
// x[3] meters to the east and so on. 
// In other words, after each move your direction changes counter-clockwise.

// Write a one-pass algorithm with O(1) extra space to determine, 
// if your path crosses itself, or not.

public class SelfCrossing {

	public boolean isSelfCrossing(int[] x) {
		for (int i = 3; i < x.length; i++) {
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
				// case 1: current line crosses the line 3 steps ahead of it
				return true;
			} else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
				// case 2: current line crosses the line 4 steps ahead of it
				return true;
			} else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3]
					&& x[i - 1] + x[i - 5] >= x[i - 3]) {
				// case 3: current line crosses the line 5 steps ahead of it
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

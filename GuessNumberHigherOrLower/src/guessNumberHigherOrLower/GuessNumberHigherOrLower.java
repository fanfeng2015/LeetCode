package guessNumberHigherOrLower;

// LeetCode #374

public class GuessNumberHigherOrLower extends GuessGame {

	public int guessNumber(int n) {
		int left = 1, right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int result = guess(mid);
			if (result == 0) {
				return mid;
			} else if (result < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
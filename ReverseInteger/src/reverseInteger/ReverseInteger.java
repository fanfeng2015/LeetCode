package reverseInteger;

// LeetCode #7 (Reverse Integer).

// Reverse digits of an integer, return 0 when the reversed integer overflows

public class ReverseInteger {

	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		int negative = x >= 0 ? 1 : -1;
		x = x >= 0 ? x : -x;
		int result = 0;
		while (x > 0) {
			if (result > (Integer.MAX_VALUE - x % 10) / 10) {
				return 0;
			} else {
				result = 10 * result + x % 10;
			}
			x = x / 10;
		}
		return negative * result;
	}

	// Time complexity is O(log(x)).
	// Space complexity is O(1).
}

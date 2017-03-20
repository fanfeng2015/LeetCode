package sqrt;

// LeetCode #69

// Implement int sqrt(int x).
// Compute and return the square root of x.

public class Sqrt {

	// Solution 1
	public int mySqrt(int x) {
		int i = 1;
		while (x >= 0) {
			x -= i;
			i += 2;
		}
		return (i - 3) / 2;
	}

	// Time complexity is O(sqrt(x)).

	// Solution 2: Binary Search
	public int mySqrt2(int x) {
		long left = 1, right = x;
		while (left < right - 1) {
			long mid = left + (right - left) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right * right <= x ? (int) right : (int) left;
	}

	// Time complexity is O(log(n)).

	// Solution 3: Newton's Method?
	public int mySqrt3(int x) {
		long r = x;
		while (r * r > x) {
			r = (r + x / r) / 2;
		}
		return (int) r;
	}
}

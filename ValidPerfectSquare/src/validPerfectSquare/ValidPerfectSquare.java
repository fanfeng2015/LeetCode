package validPerfectSquare;

// LeetCode #367

// Given a positive integer num, write a function which returns True if num is a perfect square else False.

public class ValidPerfectSquare {

	// Solution 1: Try all possible integers up to n / 2, O(n)

	// Solution 2: A perfect square can be written as 1 + 3 + 5 + 7 + ...
	public boolean isPerfectSquare(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}

	// Time complexity is O(sqrt(n)).

	// Solution 3: Binary Search
	public boolean isPerfectSquare2(int num) {
		long left = 1, right = num;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	// Time complexity is O(log(n)).

	// Solution 4: Newton's Method?
	public boolean isPerfectSquare3(int num) {
		long x = num;
		while (x * x > num) {
			x = (x + num / x) / 2;
		}
		return x * x == num;
	}

}

package palindromeNumber;

// LeetCode #9

// Determine whether an integer is a palindrome. Do this without extra space.

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return (x == reverse || x == reverse / 10);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
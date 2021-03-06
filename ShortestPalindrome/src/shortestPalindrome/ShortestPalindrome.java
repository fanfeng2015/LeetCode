package shortestPalindrome;

// LeetCode #214

// Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
// Find and return the shortest palindrome you can find by performing this transformation.

public class ShortestPalindrome {

	// Recursive solution: proof for correctness?
	public String shortestPalindrome(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(j) == s.charAt(i)) {
				j++;
			}
		}
		if (j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}

	// Time complexity is O(n), by Master Theorem.
	// Space complexity is O(n), because of call-stack.

	// Iterative solution: KMP
	public String shortestPalindrome2(String s) {
		String str = s + "#" + new StringBuilder(s).reverse().toString();
		int[] kmp = KMP(str);
		return new StringBuilder(s.substring(kmp[kmp.length - 1])).reverse().toString() + s;
	}

	private int[] KMP(String str) {
		int[] kmp = new int[str.length()];
		int i = 1, j = 0, n = str.length();
		while (i < n) {
			if (str.charAt(j) == str.charAt(i)) {
				kmp[i++] = ++j;
			} else if (j == 0) {
				i++;
			} else {
				j = kmp[j - 1];
			}
		}
		return kmp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

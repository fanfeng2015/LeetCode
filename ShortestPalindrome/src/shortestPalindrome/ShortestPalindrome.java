package shortestPalindrome;

// LeetCode #214

// Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
// Find and return the shortest palindrome you can find by performing this transformation.

public class ShortestPalindrome {

	public String shortestPalindrome(String s) {
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

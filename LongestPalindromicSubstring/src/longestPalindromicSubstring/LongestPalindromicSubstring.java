package longestPalindromicSubstring;

// LeetCode #5
// Given a string s, find the longest palindromic substring in s. 
// You may assume that the maximum length of s is 1000.

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int[][] matrix = new int[s.length()][s.length()];
		int max = 1, low = 0;
		for (int i = 0; i < s.length(); i++) {
			matrix[i][i] = 1;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i + 1; j < s.length(); j++) {
				if (j == i + 1) {
					matrix[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 0;
				} else {
					matrix[i][j] = (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1] != 0) ? matrix[i + 1][j - 1] + 2
							: 0;
				}
				if (matrix[i][j] > max) {
					max = matrix[i][j];
					low = i;
				}
			}
		}
		return s.substring(low, low + max);
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2), but we really only need O(n).

	private int lo, max;

	public String longestPalindrome2(String s) {
		if (s.length() <= 1) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			extendOnBothSides(s, i, i);
			extendOnBothSides(s, i, i + 1);
		}
		return s.substring(lo, lo + max);
	}

	private void extendOnBothSides(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (max < right - left - 1) {
			lo = left + 1;
			max = right - left - 1;
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}

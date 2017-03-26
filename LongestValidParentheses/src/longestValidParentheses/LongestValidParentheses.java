package longestValidParentheses;

import java.util.LinkedList;

// LeetCode #32

// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class LongestValidParentheses {

	// Solution 1: stack
	public int longestValidParentheses(String s) {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.offerLast(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.offerLast(i);
			} else {
				// s.charAt(i) == ')'
				if (stack.size() > 1 && s.charAt(stack.peekLast()) == '(') {
					stack.pollLast();
				} else {
					stack.offerLast(i);
				}
			}
		}
		stack.offerLast(s.length());
		int max = 0;
		while (stack.size() > 1) {
			max = Math.max(max, stack.pollLast() - stack.peekLast() - 1);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: DP
	// M[i]: length of the longest valid parentheses for substring that ends at
	// index i
	public int longestValidParentheses2(String s) {
		int max = 0;
		int[] M = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			// if s.charAt(i) == '(', M[i] = 0
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					M[i] = i - 2 >= 0 ? M[i - 2] + 2 : 2;
				} else if (i - 1 - M[i - 1] >= 0 && s.charAt(i - 1 - M[i - 1]) == '(') {
					M[i] = i - 2 - M[i - 1] >= 0 ? M[i - 2 - M[i - 1]] + 2 + M[i - 1] : 2 + M[i - 1];
				}
			}
			max = Math.max(max, M[i]);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n)
}

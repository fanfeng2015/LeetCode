package validParentheses;

import java.util.LinkedList;

// LeetCode #20 (Valid Parentheses).

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine 
// if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and
// "([)]" are not.

public class ValidParentheses {

	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.offerFirst(s.charAt(i));
			} else if (s.charAt(i) == ')' && stack.size() > 0 && stack.peekFirst() == '(') {
				stack.pollFirst();
			} else if (s.charAt(i) == ']' && stack.size() > 0 && stack.peekFirst() == '[') {
				stack.pollFirst();
			} else if (s.charAt(i) == '}' && stack.size() > 0 && stack.peekFirst() == '{') {
				stack.pollFirst();
			} else {
				return false;
			}
		}
		return stack.size() == 0;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

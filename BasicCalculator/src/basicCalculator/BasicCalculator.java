package basicCalculator;

import java.util.LinkedList;

// LeetCode #224

// Implement a basic calculator to evaluate a simple expression string.
// The expression string may contain open parentheses ( and closing parentheses ), 
// the plus + or minus sign -, non-negative integers and empty spaces.

// You may assume that the given expression is always valid.

public class BasicCalculator {

	public int calculate(String s) {
		int result = 0, sign = 1;
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int start = i;
				while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
					i++;
				}
				result += Integer.parseInt(s.substring(start, i)) * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.offerLast(result);
				stack.offerLast(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pollLast() + stack.pollLast();
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

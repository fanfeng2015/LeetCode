package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// LeetCode #301

// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
// Note: The input string may contain letters other than the parentheses ( and ).

public class RemoveInvalidParentheses {

	// Solution 1: DFS
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		remove(s, result, 0, 0, new char[] { '(', ')' });
		return result;
	}

	public void remove(String s, List<String> result, int previ, int prevj, char[] parentheses) {
		int count = 0;
		for (int i = previ; i < s.length(); i++) {
			if (s.charAt(i) == parentheses[0]) {
				count++;
			} else if (s.charAt(i) == parentheses[1]) {
				count--;
			}
			if (count >= 0) {
				continue;
			}
			for (int j = prevj; j <= i; j++) {
				if (s.charAt(j) == parentheses[1] && (j == prevj || s.charAt(j - 1) != parentheses[1])) {
					// ()()), can remove the first or the second ), but removing
					// the second and removing the third are the same
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), result, i, j, parentheses);
				}
			}
			return;
		}
		// the above is removing invalid ), also need to remove invalid ( for
		// input like (()(()
		String reversed = new StringBuilder(s).reverse().toString();
		if (parentheses[0] == '(') {
			// just finished scanning from left to right
			remove(reversed, result, 0, 0, new char[] { ')', '(' });
		} else {
			// just finished scanning from right to left
			result.add(reversed);
		}
	}

	// Solution 2: BFS (strings on level i have i deleted parentheses)
	public List<String> removeInvalidParentheses2(String s) {
		List<String> result = new ArrayList<>();
		if (s == null) {
			return result;
		}
		Set<String> visited = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>();
		visited.add(s);
		queue.offerFirst(s);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean found = false;
			for (int i = 0; i < size; i++) {
				String cur = queue.pollLast();
				if (isValid(cur)) {
					result.add(cur);
					found = true;
				}
				for (int j = 0; j < cur.length(); j++) {
					if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
						String next = cur.substring(0, j) + cur.substring(j + 1);
						if (!visited.contains(next)) {
							queue.offerFirst(next);
							visited.add(next);
						}
					}
				}
			}
			if (found) {
				return result;
			}
		}
		if (result.size() == 0) {
			result.add("");
		}
		return result;
	}

	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

	// Note:
	// 1. When there are consecutive ( or ), remove only the first one.
	// 2. When we remove a ( or a ), it must be behind its parent removal
	// position.
	// 3. If we remove a ( in the previous step, we should never remove a ) in
	// the following steps.
}
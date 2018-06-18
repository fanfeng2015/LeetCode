package simplifyPath;

import java.util.Stack;

// LeetCode #71 (Simplify Path).

// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/" => "/home"
// path = "/a/./b/../../c/" => "/c"

// Corner Cases:
// Did you consider the case where path="/../"? In this case, you should return"/".
// Another corner case is the path might contain multiple slashes '/' together, such as 
// "/home//foo/". In this case,you should ignore redundant slashes and return "/home/foo".

public class SimplifyPath {

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String cur : path.split("/")) {
			if (cur.equals("..")) {
				if (!stack.empty()) {
					stack.pop();
				}
			} else if (!cur.equals("") && !cur.equals(".")) {
				stack.push(cur);
			}
		}
		return "/" + String.join("/", stack);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

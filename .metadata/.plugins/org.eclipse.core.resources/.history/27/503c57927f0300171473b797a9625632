package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

// LeetCode #17
// Given a digit string, return all possible letter combinations that the number could represent.

public class LetterCombinationsOfAPhoneNumber {

	private String[] buttons = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		DFS(digits, result, 0, sb);
		return result;
	}

	private void DFS(String digits, List<String> result, int level, StringBuilder sb) {
		if (level == digits.length()) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < buttons[Character.getNumericValue(digits.charAt(level))].length(); i++) {
			sb.append(buttons[Character.getNumericValue(digits.charAt(level))].charAt(i));
			DFS(digits, result, level + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}

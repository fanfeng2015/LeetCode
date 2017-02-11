package reverseWordsInAString;

import java.util.Arrays;

// LeetCode #151

// Given an input string, reverse the string word by word.

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		String str = removeSpaces(s);
		char[] array = str.toCharArray();
		reverse(array, 0, array.length - 1);
		int start = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
				start = i;
			}
			if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
				reverse(array, start, i);
			}
		}
		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		while (left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	// remove all leading, trailing spaces, and duplicate spaces between words
	public String removeSpaces(String input) {
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' || fast > 0 && array[fast - 1] != ' ') {
				array[slow++] = array[fast];
			}
		}
		if (slow - 1 >= 0 && array[slow - 1] == ' ') {
			slow--;
		}
		return new String(Arrays.copyOf(array, slow));
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

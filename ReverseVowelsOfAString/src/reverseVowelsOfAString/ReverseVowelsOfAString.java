package reverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #345

// Write a function that takes a string as input and reverse only the vowels of a string.

public class ReverseVowelsOfAString {

	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>(
				Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' }));
		char[] chars = s.toCharArray();
		int left = 0, right = chars.length - 1;
		while (left < right) {
			if (!vowels.contains(chars[left])) {
				left++;
			} else if (!vowels.contains(chars[right])) {
				right--;
			} else {
				swap(chars, left++, right--);
			}
		}
		return new String(chars);
	}

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

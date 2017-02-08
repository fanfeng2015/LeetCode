package textJustification;

import java.util.ArrayList;
import java.util.List;

// LeetCode #68
// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
// You should pack your words in a greedy approach, that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary 
// so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words,
// the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example, given
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L:16
// Return
//["This    is    an", "example  of text", "justification.  "]

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int start = 0, end = 0;
		;
		while (start < words.length) {
			int count = 0;
			while (end < words.length && count + (end - start) + words[end].length() <= maxWidth) {
				count += words[end].length();
				end++;
			}
			// words at start, ..., end - 1 are on the same line
			// (maxWidth - count) white spaces are needed
			StringBuilder sb = new StringBuilder();
			if (end - start == 1 || end == words.length) {
				// only one word or last line
				for (int i = start; i < end; i++) {
					sb.append(words[i]);
					if (i < end - 1) {
						sb.append(" ");
					}
				}
				int spaces = maxWidth - sb.length();
				for (int i = 0; i < spaces; i++) {
					sb.append(" ");
				}
			} else {
				int average = (maxWidth - count) / (end - start - 1);
				int extra = (maxWidth - count) % (end - start - 1);
				for (int i = start; i < end; i++) {
					sb.append(words[i]);
					if (i < end - 1) {
						for (int j = 0; j < average; j++) {
							sb.append(" ");
						}
					}
					if (i < start + extra) {
						sb.append(" ");
					}
				}
			}
			result.add(sb.toString());
			start = end;
		}
		return result;
	}
}

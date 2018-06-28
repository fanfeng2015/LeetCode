package textJustification;

import java.util.ArrayList;
import java.util.List;

// LeetCode #68 (Text Justification).

// Given an array of words and a length L, format the text such that each line has exactly L characters 
// and is fully (left and right) justified. You should pack your words in a greedy approach, that is, 
// pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has
// exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a 
// line do not divide evenly between words, the empty slots on the left will be assigned more spaces than
// the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example, given words ["This", "is", "an", "example", "of", "text", "justification."] and maxWidth 16,
// return ["This    is    an", "example  of text", "justification.  "]

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int start = 0, end = 0;
		while (start < words.length) {
			int wordsLength = 0;
			while (end < words.length && wordsLength + (end - start) + words[end].length() <= maxWidth) {
				wordsLength += words[end].length();
				end++;
			}
			// words in [start, ..., end - 1] are on the same line, need
			// (maxWidth - wordsLength) white spaces
			StringBuilder sb = new StringBuilder();
			if (end - start == 1 || end == words.length) { // only one word or last line
				for (int i = start; i < end; i++) {
					sb.append(words[i]).append(" ");
				}
				sb.deleteCharAt(sb.length() - 1); // delete last white space
				append(sb, maxWidth - sb.length());
			} else {
				int average = (maxWidth - wordsLength) / (end - start - 1);
				int extra = (maxWidth - wordsLength) % (end - start - 1);
				for (int i = start; i < end; i++) {
					sb.append(words[i]);
					if (i < end - 1) {
						append(sb, average);
					}
					if (i < start + extra) {
						append(sb, 1);
					}
				}
			}
			result.add(sb.toString());
			start = end;
		}
		return result;
	}

	// Appends n white spaces to string builder.
	private void append(StringBuilder sb, int n) {
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
	}

}

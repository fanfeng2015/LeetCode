package wordLadder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #127 (Word Ladder).

// Given two words (beginWord and endWord), and a dictionary's word list, find the length
// of shortest transformation sequence from beginWord to endWord, such that:

// 1. Only one letter can be changed at a time.
// 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed
//    word.

// Note:
// 1. Return 0 if there is no such transformation sequence.
// 2. All words have the same length.
// 3. All words contain only lower case alphabetic characters.
// 4. You may assume no duplicates in the word list.
// 5. You may assume beginWord and endWord are non-empty and are not the same.

public class WordLadder {

	// BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictionary = new HashSet<>(wordList);
		if (!dictionary.contains(endWord)) {
			return 0;
		}
		int length = 1;
		Set<String> visited = new HashSet<>();
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// optimization: swap beginSet and endSet to save time
			if (beginSet.size() > endSet.size()) {
				swap(beginSet, endSet);
			}
			// try out all 26 possible characters for each char of each string in beginSet
			Set<String> temp = new HashSet<>();
			for (String s : beginSet) {
				char[] chars = s.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char originalChar = chars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c; // modify
						String newWord = String.valueOf(chars);
						if (endSet.contains(newWord)) {
							return length + 1;
						}
						if (!visited.contains(newWord) && dictionary.contains(newWord)) {
							visited.add(newWord);
							temp.add(newWord);
						}
						chars[i] = originalChar; // modify back
					}
				}
			}
			beginSet = temp;
			length++;
		}
		return 0;
	}

	private void swap(Set<String> beginSet, Set<String> endSet) {
		Set<String> temp = beginSet;
		beginSet = endSet;
		endSet = temp;
	}

	// Follow up: Return all shortest transformation sequences.
	// LeetCode #126 (Word Ladder II).
}

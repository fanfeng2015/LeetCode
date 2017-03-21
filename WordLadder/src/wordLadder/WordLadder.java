package wordLadder;

// LeetCode #127

// Given two words (beginWord and endWord), and a dictionary's word list, 
// find the length of shortest transformation sequence from beginWord to endWord, such that:
// 1. Only one letter can be changed at a time.
// 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	// BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictionary = new HashSet<>(wordList);
		if (!dictionary.contains(endWord)) {
			return 0;
		}
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		Set<String> visited = new HashSet<>();
		int length = 1;
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// swap beginSet and endSet to optimize time
			if (beginSet.size() > endSet.size()) {
				Set<String> temp = beginSet;
				beginSet = endSet;
				endSet = temp;
			}
			// try out all 26 possible characters for each char of each String
			// in beginSet
			Set<String> temp = new HashSet<>();
			for (String s : beginSet) {
				char[] charArray = s.toCharArray();
				for (int i = 0; i < charArray.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char originalChar = charArray[i];
						charArray[i] = c;
						String newString = String.valueOf(charArray);
						if (endSet.contains(newString)) {
							return length + 1;
						}
						if (!visited.contains(newString) && dictionary.contains(newString)) {
							visited.add(newString);
							temp.add(newString);
						}
						charArray[i] = originalChar;
					}
				}
			}
			beginSet = temp;
			length++;
		}
		return 0;
	}

}

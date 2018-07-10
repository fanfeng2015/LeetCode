package wordLadder2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #126 (Word Ladder II).

// Given two words (beginWord and endWord), and a dictionary's word list, find all 
// shortest transformation sequence(s) from beginWord to endWord, such that:

// 1. Only one letter can be changed at a time
// 2. Each transformed word must exist in the word list. Note that beginWord is not 
//    a transformed word.

// Note:
// 1. Return an empty list if there is no such transformation sequence.
// 2. All words have the same length.
// 3. All words contain only lowercase alphabetic characters.
// 4. You may assume no duplicates in the word list.
// 5. You may assume beginWord and endWord are non-empty and are not the same.

public class WordLadder2 {

	// BFS + DFS
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		BFS(new HashSet<>(wordList), beginSet, endSet, map, false);

		List<String> solution = new ArrayList<String>(Arrays.asList(beginWord));
		List<List<String>> result = new ArrayList<List<String>>();
		DFS(beginWord, endWord, map, solution, result);

		return result;
	}

	// BFS: construct the map
	private boolean BFS(Set<String> dictionary, Set<String> beginSet, Set<String> endSet, Map<String, List<String>> map,
			boolean downward) {
		if (beginSet.isEmpty()) {
			return false;
		}
		// optimization: swap beginSet and endSet to save time
		if (beginSet.size() > endSet.size()) {
			return BFS(dictionary, endSet, beginSet, map, !downward);
		}
		dictionary.removeAll(beginSet);
		dictionary.removeAll(endSet);

		boolean shortestFound = false;
		Set<String> temp = new HashSet<String>(); // next level of BFS

		// try out all 26 possible characters for each char of each string in beginSet
		for (String s : beginSet) {
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char originalChar = chars[i];
				for (char ch = 'a'; ch <= 'z'; ch++) {
					chars[i] = ch; // modify
					String word = new String(chars);
					// check direction
					String key = downward ? word : s;
					String value = downward ? s : word;
					List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
					if (endSet.contains(word)) {
						shortestFound = true;
						list.add(value);
						map.put(key, list);
					}
					if (!shortestFound && dictionary.contains(word)) { // TODO: visited?
						temp.add(word);
						list.add(value);
						map.put(key, list);
					}
					chars[i] = originalChar; // modify back
				}
			}
		}
		return shortestFound || BFS(dictionary, beginSet, endSet, map, !downward);
	}

	private void DFS(String beginWord, String endWord, Map<String, List<String>> map, List<String> solution,
			List<List<String>> result) {
		if (!map.containsKey(beginWord)) {
			return;
		}
		if (beginWord.equals(endWord)) {
			result.add(new ArrayList<String>(solution));
			return;
		}
		for (String nextWord : map.get(beginWord)) {
			solution.add(nextWord);
			DFS(nextWord, endWord, map, solution, result);
			solution.remove(solution.size() - 1);
		}
	}

}

package shortestWordDistance2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #244
// This is a follow up of Shortest Word Distance. 
// The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. 
// How would you optimize it?
// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 
// and return the shortest distance between these two words in the list.

public class ShortestWordDistance2 {

	Map<String, List<Integer>> map;

	public ShortestWordDistance2(String[] words) {
		this.map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			List<Integer> list = map.get(words[i]);
			list = list == null ? new ArrayList<Integer>() : list;
			list.add(i); // indices are in ascending order
			map.put(words[i], list);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1), list2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {
			int index1 = list1.get(i), index2 = list2.get(j);
			if (index1 < index2) {
				min = Math.min(min, index2 - index1);
				i++;
			} else if (index1 > index2) {
				min = Math.min(min, index1 - index2);
				j++;
			}
		}
		return min;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

package sortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #451

// Given a string, sort it in decreasing order based on the frequency of characters.

public class SortCharactersByFrequency {

	// Solution 1: Priority Queue
	public String frequencySort(String s) {
		if (s.length() <= 1) {
			return s;
		}
		char[] result = new char[s.length()];
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				s.length(), new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
						if (e1.getValue() == e2.getValue()) {
							return 0;
						}
						return e1.getValue() > e2.getValue() ? -1 : 1;
					}
				});
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}
		int index = 0;
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				result[index++] = entry.getKey();
			}
		}
		return new String(result);
	};

	// Time complexity is O(n * log(n)).
	// Space complexity is O(n).

	// Solution 2: Bucket Sort
	public String frequencySort2(String s) {
		if (s.length() <= 1) {
			return s;
		}
		char[] result = new char[s.length()];
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		List<Character>[] buckets = new List[s.length() + 1];
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int frequency = entry.getValue();
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<Character>();
			}
			buckets[frequency].add(entry.getKey());
		}
		int index = 0;
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] != null) {
				for (Character ch : buckets[i]) {
					for (int j = 0; j < i; j++) {
						result[index++] = ch;
					}
				}
			}
		}
		return new String(result);
	};

	// Time complexity is O(n).
	// Space complexity is O(n).
}

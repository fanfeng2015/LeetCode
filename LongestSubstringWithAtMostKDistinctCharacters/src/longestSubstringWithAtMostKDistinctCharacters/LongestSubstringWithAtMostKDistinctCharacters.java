package longestSubstringWithAtMostKDistinctCharacters;

// LeetCode #340 (Longest Substring with At Most K Distinct Characters).

// Given a string, find the length of the longest substring T that contains at 
// most k distinct characters.

public class LongestSubstringWithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0) {
			return 0;
		}
		int max = 0, lo = 0;
		Entity[] entities = new Entity[k];
		for (int i = 0; i < s.length(); i++) {
			boolean found = false;
			for (int j = 0; j < k; j++) {
				if (entities[j] == null) {
					entities[j] = new Entity(s.charAt(i), i);
					found = true;
					break;
				} else if (s.charAt(i) == entities[j].ch) {
					entities[j].lastOccurrence = i;
					found = true;
					break;
				}
			}
			if (!found) {
				int min = findMinLastOccurrence(entities);
				lo = entities[min].lastOccurrence + 1;
				entities[min] = new Entity(s.charAt(i), i);
			}
			max = Math.max(max, i - lo + 1);

		}
		return max;
	}

	private int findMinLastOccurrence(Entity[] entities) {
		int min = 0;
		for (int i = 0; i < entities.length; i++) {
			if (entities[i].lastOccurrence < entities[min].lastOccurrence) {
				min = i;
			}
		}
		return min;
	}

	private static class Entity {
		char ch;
		int lastOccurrence;

		Entity(char ch, int lastOccurrence) {
			this.ch = ch;
			this.lastOccurrence = lastOccurrence;
		}
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k).
}

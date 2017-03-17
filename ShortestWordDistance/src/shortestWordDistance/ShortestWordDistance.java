package shortestWordDistance;

// LeetCode #243

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int one = -1, two = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				one = i;
			}
			if (words[i].equals(word2)) {
				two = i;
			}
			if (one != -1 && two != -1) {
				min = Math.min(min, Math.abs(one - two));
			}
		}
		return min;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

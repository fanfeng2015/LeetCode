package shortestWordDistance;

// LeetCode #243 (Shortest Word Distance).

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int one = -1, two = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			one = words[i].equals(word1) ? i : one;
			two = words[i].equals(word2) ? i : two;
			if (one != -1 && two != -1) {
				min = Math.min(min, Math.abs(one - two));
			}
		}
		return min;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
	
	// Follow up: LeetCode #244 (Shortest Distance II), #245 (Shortest Distance III).
}

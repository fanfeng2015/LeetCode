package removeDuplicateLetters;

// LeetCode #316

// Given a string which contains only lower-case letters, 
// remove duplicate letters so that every letter appear once and only once. 
// You must make sure your result is the smallest in lexicographical order 
// among all possible results.

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		boolean[] visited = new boolean[26];
		char[] chars = s.toCharArray();
		for (char ch : chars) {
			count[ch - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			int index = ch - 'a';
			count[index]--;
			if (!visited[index]) {
				while (sb.length() > 0 && ch < sb.charAt(sb.length() - 1)
						&& count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
					visited[sb.charAt(sb.length() - 1) - 'a'] = false;
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(ch);
				visited[index] = true;
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
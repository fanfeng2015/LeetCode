package ransomNote;

// LeetCode #383

// Given an arbitrary ransom note string and another string containing letters 
// from all the magazines, write a function that will return true if the ransom note 
// can be constructed from the magazines; otherwise, it will return false.

// Each letter in the magazine string can only be used once in your ransom note.

// You may assume that both strings contain only lower-case letters.

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			count[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--count[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1), assuming strings only contain lower-case
	// letters.
}

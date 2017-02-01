package firstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

// LeetCode #387
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			if (count == null) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), count + 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but really the space it takes is only the
	// number of possible characters (256?), is no worse then using
	// int[] array = new int[256].
}

package longestPalindrome;

import java.util.HashMap;
import java.util.Map;

// LeetCode #409

// Given a string which consists of lower-case or upper-case letters, 
// find the length of the longest palindromes that can be built with those letters.
// This is case sensitive, for example "Aa" is not considered a palindrome here.

public class LongestPalindrome {

	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			Integer count = map.get(ch);
			count = count == null ? 1 : count + 1;
			map.put(ch, count);
		}
		int result = 0, carry = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			result += entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
			carry = entry.getValue() % 2 == 0 ? carry : 1;
		}
		return result + carry;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
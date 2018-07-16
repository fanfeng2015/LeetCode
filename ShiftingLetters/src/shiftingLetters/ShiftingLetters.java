package shiftingLetters;

// LeetCode #848 (Shifting Letters).

// We have a string S of lower case letters, and an integer array shifts. Call the shift
// of a letter, the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). 

// For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'. Now for each 
// shifts[i] = x, we want to shift the first i+1 letters of S, x times.

// Return the final string after all such shifts to S are applied.

public class ShiftingLetters {

	public String shiftingLetters(String S, int[] shifts) {
		int m = S.length(), n = shifts.length;
		long sum = 0;
		char[] chars = S.toCharArray();
		for (int i = n - 1; i >= m; i--) {
			sum += shifts[i];
		}
		for (int i = m - 1; i >= 0; i--) {
			sum += shifts[i];
			chars[i] += (sum % 26);
			chars[i] = (chars[i] > 'z') ? (char) (chars[i] - 26) : chars[i];
		}
		return new String(chars);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

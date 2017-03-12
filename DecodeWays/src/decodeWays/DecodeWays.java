package decodeWays;

// LeetCode #91

public class DecodeWays {

	// M[i]: number of ways to encode substring from index i to n - 1
	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] M = new int[s.length() + 1];
		M[s.length()] = 1;
		M[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				int cur = Integer.parseInt(s.substring(i, i + 2));
				M[i] = cur <= 26 ? M[i + 1] + M[i + 2] : M[i + 1];
			}
		}
		return M[0];
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
package reverseBits;

// LeetCode #190

// Reverse bits of a given 32 bits unsigned integer.

public class ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1;
			if (i < 31) {
				result <<= 1;
			}
		}
		return result;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

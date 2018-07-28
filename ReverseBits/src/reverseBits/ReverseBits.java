package reverseBits;

// LeetCode #190 (Reverse Bits).

// Reverse bits of a given 32 bits unsigned integer.

public class ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1;
			result <<= (i < 31) ? 1 : 0; // don't left shift on the last bit
		}
		return result;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

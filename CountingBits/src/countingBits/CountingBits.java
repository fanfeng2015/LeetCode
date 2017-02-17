package countingBits;

public class CountingBits {

	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			result[i] = result[i / 2] + i % 2;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring space needed for output.
}
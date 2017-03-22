package fourSum2;

import java.util.HashMap;
import java.util.Map;

// LeetCode #454

public class FourSum2 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				Integer count = map.get(A[i] + B[j]);
				count = count == null ? 1 : count + 1;
				map.put(A[i] + B[j], count);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				Integer count = map.get(0 - C[i] - D[j]);
				result += count == null ? 0 : count;
			}
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).
}

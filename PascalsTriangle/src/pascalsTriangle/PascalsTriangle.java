package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

// LeetCode #118
// Given numRows, generate the first numRows of Pascal's triangle.

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		if (numRows < 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			cur.add(0, 1);
			for (int j = 1; j < cur.size() - 1; j++) {
				cur.set(j, cur.get(j) + cur.get(j + 1));
			}
			result.add(new ArrayList<Integer>(cur));
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), ignoring space needed for output.
}

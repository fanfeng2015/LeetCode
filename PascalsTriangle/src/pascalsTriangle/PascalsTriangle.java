package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

// LeetCode #118 (Pascal's Triangle).

// Given numRows, generate the first numRows of Pascal's triangle.

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows < 0) {
			return result;
		}
		List<Integer> prev = new ArrayList<>(), cur = new ArrayList<>();
		prev.add(1);
		for (int i = 0; i < numRows; i++) {
			result.add(new ArrayList<Integer>(prev));
			cur.add(1);
			for (int j = 0; j < prev.size() - 1; j++) {
				cur.add(prev.get(j) + prev.get(j + 1));
			}
			cur.add(1);
			prev = cur;
			cur = new ArrayList<>();
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), ignoring space needed for output.
}

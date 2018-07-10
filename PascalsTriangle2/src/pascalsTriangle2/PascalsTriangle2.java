package pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

// LeetCode #119 (Pascal's Triangle II).

// Given an index k, return the k-th row of the Pascal's triangle.

public class PascalsTriangle2 {

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return new ArrayList<>();
		}
		List<Integer> prev = new ArrayList<>(), cur = new ArrayList<>();
		prev.add(1);
		for (int i = 0; i < rowIndex; i++) {
			cur.add(1);
			for (int j = 0; j < prev.size() - 1; j++) {
				cur.add(prev.get(j) + prev.get(j + 1));
			}
			cur.add(1);
			prev = cur;
			cur = new ArrayList<>();
		}
		return prev;
	}

	// Time complexity is O(k^2).
	// Space complexity is O(k).
}

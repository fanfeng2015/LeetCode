package combinations;

import java.util.ArrayList;
import java.util.List;

// LeetCode #77 (Combinations).

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS(cur, result, n, k);
		return result;
	}

	private void DFS(List<Integer> cur, List<List<Integer>> result, int n, int k) {
		if (cur.size() == k) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = cur.size() == 0 ? 1 : cur.get(cur.size() - 1) + 1; i <= n; i++) {
			cur.add(i);
			DFS(cur, result, n, k);
			cur.remove(cur.size() - 1);
		}
	}
	
	// Time complexity is O(n^k).
	// Space complexity is O(k).
}

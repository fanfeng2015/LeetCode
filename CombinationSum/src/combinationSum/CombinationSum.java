package combinationSum;

import java.util.ArrayList;
import java.util.List;

// LeetCode #39 (Combination Sum).

// Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
// find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS(result, cur, candidates, target, 0);
		return result;
	}

	private void DFS(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			cur.add(candidates[i]);
			DFS(result, cur, candidates, target - candidates[i], i);
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(n^target).
	// Space complexity is O(target).

	// LaiCode: Combinations of Coins
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS2(result, cur, candidates, target, 0);
		return result;
	}

	private void DFS2(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int level) {
		if (level == candidates.length) {
			if (target == 0) {
				add(result, cur, candidates);
			}
			return;
		}
		for (int i = 0; i <= target / candidates[level]; i++) {
			cur.add(i);
			DFS2(result, cur, candidates, target - i * candidates[level], level + 1);
			cur.remove(cur.size() - 1);
		}
	}

	private void add(List<List<Integer>> result, List<Integer> cur, int[] candidates) {
		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < cur.size(); i++) { // add candidates[i] cur.get(i) many times
			for (int j = 0; j < cur.get(i); j++) {
				r.add(candidates[i]);
			}
		}
		result.add(r);
	}

	// Time complexity is O(target^n), ignoring time that add(...) takes.
	// Space complexity is O(n).
}

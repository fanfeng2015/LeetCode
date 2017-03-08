package combinationSum;

import java.util.ArrayList;
import java.util.List;

// LeetCode #39

// Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
// find all unique combinations in C where the candidate numbers sums to T.
//The same repeated number may be chosen from C unlimited number of times.

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS(result, cur, candidates, target, 0);
		return result;
	}

	private void DFS(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int level) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = level; i < candidates.length; i++) {
			cur.add(candidates[i]);
			DFS(result, cur, candidates, target - candidates[i], i);
			cur.remove(cur.size() - 1);
		}
	}

}

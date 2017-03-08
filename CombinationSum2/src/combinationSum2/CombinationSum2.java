package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #40

// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// Each number in C may only be used once in the combination.

public class CombinationSum2 {

	// Solution 1
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
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
			if (i > level && candidates[i] == candidates[i - 1]) {
				continue;
			}
			cur.add(candidates[i]);
			DFS(result, cur, candidates, target - candidates[i], i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	// Solution 2
	private int[] nums;
	private int[] count;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		getCount(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS2(result, cur, nums, count, target, 0);
		return result;
	}

	private void getCount(int[] candidates) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int candidate : candidates) {
			Integer count = map.get(candidate);
			count = count == null ? 1 : count + 1;
			map.put(candidate, count);
		}
		nums = new int[map.size()];
		count = new int[map.size()];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			nums[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
	}

	private void DFS2(List<List<Integer>> result, List<Integer> cur, int[] nums, int[] count, int target, int level) {
		if (level == nums.length) {
			if (target == 0) {
				add(result, cur, nums);
			}
			return;
		}
		for (int i = 0; i <= Math.min(target / nums[level], count[level]); i++) {
			cur.add(i);
			DFS2(result, cur, nums, count, target - i * nums[level], level + 1);
			cur.remove(cur.size() - 1);
		}
	}

	private void add(List<List<Integer>> result, List<Integer> cur, int[] candidates) {
		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < cur.size(); i++) {
			for (int j = 0; j < cur.get(i); j++) {
				r.add(candidates[i]);
			}
		}
		result.add(r);
	}

}

package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #40 (Combination Sum II).

// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// Each number in C may only be used once in the combination.

public class CombinationSum2 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates); // important
		DFS(candidates, target, cur, result, 0);
		return result;
	}

	private void DFS(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			cur.add(candidates[i]);
			DFS(candidates, target - candidates[i], cur, result, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(n^target).
	// Space complexity is O(target).
	
	private int[] nums;
	private int[] count;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		getCount(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS2(nums, count, target, cur, result, 0);
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

	private void DFS2(int[] nums, int[] count, int target, List<Integer> cur, List<List<Integer>> result, int level) {
		if (level == nums.length) {
			if (target == 0) {
				add(nums, cur, result);
			}
			return;
		}
		for (int i = 0; i <= Math.min(target / nums[level], count[level]); i++) {
			cur.add(i);
			DFS2(nums, count, target - i * nums[level], cur, result, level + 1);
			cur.remove(cur.size() - 1);
		}
	}

	private void add(int[] candidates, List<Integer> cur, List<List<Integer>> result) {
		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < cur.size(); i++) {
			for (int j = 0; j < cur.get(i); j++) {
				r.add(candidates[i]);
			}
		}
		result.add(r);
	}

	// Time complexity is O(target^n), ignoring time that add(...) takes.
	// Space complexity is O(n).
}

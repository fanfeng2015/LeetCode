package theSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// LeetCode #218

// https://leetcode.com/problems/the-skyline-problem/?tab=Description

public class TheSkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> heights = new ArrayList<>();
		for (int[] building : buildings) {
			heights.add(new int[] { building[0], -building[2] });
			heights.add(new int[] { building[1], building[2] });
		}
		Collections.sort(heights, new Comparator<int[]>() {
			@Override
			public int compare(int[] one, int[] two) {
				if (one[0] != two[0]) {
					return one[0] < two[0] ? -1 : 1;
				} else if (one[1] != two[1]) {
					return one[1] < two[1] ? -1 : 1;
				}
				return 0;
			}
		});
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(heights.size(), new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				if (x == y) {
					return 0;
				}
				return x > y ? -1 : 1;
			}
		});
		maxHeap.offer(0);
		int prev = 0;
		for (int[] height : heights) {
			if (height[1] < 0) {
				maxHeap.offer(-height[1]);
			} else {
				maxHeap.remove(height[1]);
			}
			int cur = maxHeap.peek();
			if (prev != cur) {
				result.add(new int[] { height[0], cur });
				prev = cur;
			}
		}
		return result;
	}

	// Time complexity is O(n^2), because remove from a priority queue takes
	// O(n) time.
	// Space complexity is O(n).
}

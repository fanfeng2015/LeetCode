package theSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// LeetCode #218 (The Skyline Problem).

public class TheSkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		if (buildings == null || buildings.length == 0) {
			return result;
		}

		List<int[]> heights = new ArrayList<>();
		for (int[] building : buildings) {
			heights.add(new int[] { building[0], -building[2] });
			heights.add(new int[] { building[1], building[2] });
		}
		// lambda expression
		Collections.sort(heights, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		int prev = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(heights.size(), (a, b) -> (b - a));
		maxHeap.offer(0);

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

	// Time complexity is O(n^2), because remove from a priority queue takes O(n)
	// time.
	// Space complexity is O(n).
}

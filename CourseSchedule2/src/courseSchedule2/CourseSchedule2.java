package courseSchedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #210

public class CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incomingCount = new int[numCourses];
		List<List<Integer>> adjacentList = new ArrayList<>();
		constructGraph(prerequisites, incomingCount, adjacentList);
		return topologicalOrder(incomingCount, adjacentList);
	}

	private void constructGraph(int[][] prerequisites, int[] incomingCount, List<List<Integer>> adjacentList) {
		int n = incomingCount.length;
		for (int i = 0; i < n; i++) {
			adjacentList.add(new ArrayList<Integer>());
		}
		for (int[] prereq : prerequisites) {
			incomingCount[prereq[0]]++;
			adjacentList.get(prereq[1]).add(prereq[0]);
		}
	}

	private int[] topologicalOrder(int[] incomingCount, List<List<Integer>> adjacentList) {
		int n = incomingCount.length;
		int[] result = new int[n];
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (incomingCount[i] == 0) {
				queue.offerFirst(i);
			}
		}
		int index = 0;
		while (!queue.isEmpty()) {
			int cur = queue.pollLast();
			result[index++] = cur;
			for (int next : adjacentList.get(cur)) {
				incomingCount[next]--;
				if (incomingCount[next] == 0) {
					queue.offerFirst(next);
				}
			}
		}
		return index == n ? result : new int[] {};
	}

}
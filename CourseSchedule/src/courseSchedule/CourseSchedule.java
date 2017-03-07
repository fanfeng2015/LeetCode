package courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #207

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] incomingCount = new int[numCourses];
		List<List<Integer>> adjacentList = new ArrayList<>();
		constructGraph(prerequisites, incomingCount, adjacentList);
		return topologicalOrder(incomingCount, adjacentList) == numCourses;
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

	private int topologicalOrder(int[] incomingCount, List<List<Integer>> adjacentList) {
		int n = incomingCount.length;
		int count = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (incomingCount[i] == 0) {
				queue.offerFirst(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.pollLast();
			count++;
			for (int next : adjacentList.get(cur)) {
				incomingCount[next]--;
				if (incomingCount[next] == 0) {
					queue.offerFirst(next);
				}
			}
		}
		return count;
	}

}
package queueReconstructionByHeight;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

// LeetCode #406 (Queue Reconstruction by Height).

// Suppose you have a random list of people standing in a queue. Each person is described by
// a pair of integers (h, k), where h is the height of the person and k is the number of people
// in front of this person who have a height greater than or equal to h. Write an algorithm to 
// reconstruct the queue.

public class QueueReconstructionByHeight {

	public int[][] reconstructQueue(int[][] people) {
		// sort in descending order of h, then by ascending order of k
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0]) {
					return a[1] < b[1] ? -1 : 1;
				}
				return b[0] < a[0] ? -1 : 1;
			}
		});
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
		}
		int[][] result = new int[people.length][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}

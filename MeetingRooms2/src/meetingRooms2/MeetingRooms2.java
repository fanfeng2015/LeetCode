package meetingRooms2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// LeetCode #253 (Meeting Rooms 2).

// Given an array of meeting time intervals consisting of start and end times
// [[s1, e1], [s2, e2], ...] (si < ei), find the minimum number of conference 
// rooms required.

public class MeetingRooms2 {

	// Solution 1: sort + heap
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new IntervalStartComparator());
		PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.length, new IntervalEndComparator());
		minHeap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval cur = minHeap.peek();
			// cur and intervals[i] can use the same meeting room, therefore merge them
			if (cur.end <= intervals[i].start) {
				cur.end = intervals[i].end;
			} else {
				minHeap.offer(intervals[i]);
			}
		}
		return minHeap.size();
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Solution 2: sort start and end respectively
	public int minMeetingRooms2(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);

		int count = 0;
		int curEndIndex = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (starts[i] < ends[curEndIndex]) {
				count++;
			} else {
				curEndIndex++;
			}
		}
		return count;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	private class IntervalStartComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return 0;
			}
			return i1.start < i2.start ? -1 : 1;
		}
	}

	private class IntervalEndComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.end == i2.end) {
				return 0;
			}
			return i1.end < i2.end ? -1 : 1;
		}
	}

	// Note: On a second thought, the two solutions are actually the same.
}

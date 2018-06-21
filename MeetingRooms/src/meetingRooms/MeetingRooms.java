package meetingRooms;

import java.util.Arrays;
import java.util.Comparator;

// LeetCode #252 (Meeting Rooms).

// Given an array of meeting time intervals consisting of start and end times 
// [[s1, e1], [s2, e2], ...] (si < ei), determine if a person could attend all
// meetings.

public class MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return 0;
			}
			return i1.start < i2.start ? -1 : 1;
		}
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}

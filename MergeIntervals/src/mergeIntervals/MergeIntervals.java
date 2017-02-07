package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// LeetCode #56
// Given a collection of intervals, merge all overlapping intervals.

public class MergeIntervals {

	public class MyComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return 0;
			}
			return i1.start < i2.start ? -1 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new MyComparator());
		for (int i = 0; i < intervals.size(); i++) {
			if (result.size() == 0 || intervals.get(i).start > result.get(result.size() - 1).end) {
				result.add(intervals.get(i));
			} else {
				result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
			}
		}
		return result;
	}

	// Time complexity is O(n * log(n)).
	// Space complexity is O(n), because Java sorts non-primitive types with
	// Merge Sort.
}

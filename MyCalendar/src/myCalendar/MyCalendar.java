package myCalendar;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// LeetCode #729 (My Calendar I).

// Implement a MyCalendar class to store your events. A new event can be added if adding the event
// will not cause a double booking.

// Your class will have the method, book(int start, int end). Formally, this represents a booking on
// the half open interval [start, end), the range of real numbers x such that start <= x < end.

// A double booking happens when two events have some non-empty intersection (i.e., there is some time
// that is common to both events.)

// For each call to the method MyCalendar.book, return true if the event can be added to the calendar 
// successfully without causing a double booking. Otherwise, return false and do not add the event to 
// the calendar.

// Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end);

public class MyCalendar {

	// Solution 1: Two sorted lists.
	List<Integer> starts = new ArrayList<>();
	List<Integer> ends = new ArrayList<>();

	public MyCalendar() {
	}

	public boolean book(int start, int end) {
		int index = largestSmallerOrEqual(ends, start);
		if (index == starts.size() - 1 || starts.get(index + 1) >= end) {
			insertToCalendar(start, end, index + 1);
			return true;
		}
		return false;
	}

	// Returns the index of the largest number smaller than or equal to target.
	private int largestSmallerOrEqual(List<Integer> ends, int target) {
		if (ends == null || ends.size() == 0) {
			return -1;
		}
		int left = 0, right = ends.size() - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (ends.get(mid) <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (ends.get(right) <= target) {
			return right;
		} else if (ends.get(left) <= target) {
			return left;
		}
		return -1;
	}

	// Insert start and end at index in starts and ends.
	private void insertToCalendar(int start, int end, int index) {
		starts.add(index, start);
		ends.add(index, end);
	}

	// Time complexity is O(n)
	// Space complexity is O(n).

	// Note: You might as well just keep the list(s) unsorted and do sequential
	// search. Time/space complexity is the same.

	// Solution 2: Red-black tree (TreeMap in Java).
	TreeMap<Integer, Integer> calendar = new TreeMap<>();

	public boolean book2(int start, int end) {
		Integer floorKey = calendar.floorKey(start); // the greatest key <= start
		if (floorKey != null && start < calendar.get(floorKey)) {
			return false;
		}
		Integer ceilingKey = calendar.ceilingKey(start); // the least key >= start
		if (ceilingKey != null && end > ceilingKey) {
			return false;
		}
		calendar.put(start, end);
		return true;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(n).
}

package myCalendar2;

import java.util.Map;
import java.util.TreeMap;

// LeetCode #731 (My Calendar II).

// Implement a MyCalendar2 class to store your events. A new event can be added if adding the event will not
// cause a triple booking.

// Your class will have one method, book(int start, int end). Formally, this represents a booking on the half
// open interval [start, end), the range of real numbers x such that start <= x < end.

// A triple booking happens when three events have some non-empty intersection (ie., there is some time that 
// is common to all 3 events.)

// For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
// without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

// Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end);

public class MyCalendar2 {

	TreeMap<Integer, Integer> calendar; // { t: count of intervals that start from t }

	public MyCalendar2() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		calendar.put(start, calendar.getOrDefault(start, 0) + 1);
		calendar.put(end, calendar.getOrDefault(end, 0) - 1);
		int overlap = 0;
		for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) { // in ascending key order
			overlap += entry.getValue();
			if (overlap == 3) {
				calendar.put(start, calendar.get(start) - 1);
				calendar.put(end, calendar.get(end) + 1);
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

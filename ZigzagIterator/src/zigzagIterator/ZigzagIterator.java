package zigzagIterator;

import java.util.List;

// LeetCode #281 (Zigzag Iterator).

// Given two 1d vectors, implement an iterator to return their elements alternately.

public class ZigzagIterator {

	private boolean fromV1 = true; // next() should pick from v1
	private int i1 = 0, i2 = 0;
	private List<Integer> v1, v2;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int next() {
		Integer result = ((fromV1 || i2 >= v2.size()) && i1 < v1.size()) ? v1.get(i1++) : v2.get(i2++);
		fromV1 = !fromV1; // once one of v1 and v2 reached the end, the flag no longer matters
		return result;
	}

	public boolean hasNext() {
		return i1 < v1.size() || i2 < v2.size();
	}

}

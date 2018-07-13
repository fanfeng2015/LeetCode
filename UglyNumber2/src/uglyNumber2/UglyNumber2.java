package uglyNumber2;

import java.util.Arrays;
import java.util.LinkedList;

// LeetCode #264 (Ugly Number II).

// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

public class UglyNumber2 {

	public int nthUglyNumber(int n) {
		Long result = 1L;
		LinkedList<Long> two = new LinkedList<>(Arrays.asList(new Long[] { 2 * result }));
		LinkedList<Long> three = new LinkedList<>(Arrays.asList(new Long[] { 3 * result }));
		LinkedList<Long> five = new LinkedList<>(Arrays.asList(new Long[] { 5 * result }));
		for (int i = 0; i < n - 1; i++) {
			if (two.peekFirst() < three.peekFirst() && two.peekFirst() < five.peekFirst()) {
				result = two.pollFirst();
				two.offerLast(2 * result);
				three.offerLast(3 * result);
				five.offerLast(5 * result);
			} else if (three.peekFirst() < five.peekFirst()) {
				result = three.pollFirst();
				three.offerLast(3 * result);
				five.offerLast(5 * result);
			} else {
				result = five.pollFirst();
				five.offerLast(5 * result);
			}
		}
		return result.intValue();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

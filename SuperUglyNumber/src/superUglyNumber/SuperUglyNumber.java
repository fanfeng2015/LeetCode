package superUglyNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// LeetCode #313 (Super Ugly Number).

// Write a program to find the nth super ugly number.

// Super ugly numbers are positive numbers whose all prime factors are
// in the given prime list primes of size k.

public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		Long result = 1L;
		List<LinkedList<Long>> lists = new ArrayList<>();
		for (int i = 0; i < primes.length; i++) {
			lists.add(new LinkedList<Long>(Arrays.asList(new Long[] { primes[i] * result })));
		}

		for (int i = 0; i < n - 1; i++) {
			int min = findMin(lists); // index
			result = lists.get(min).pollFirst();
			for (int j = min; j < primes.length; j++) {
				lists.get(j).offerLast(primes[j] * result);
			}
		}
		return result.intValue();
	}

	private int findMin(List<LinkedList<Long>> lists) {
		int min = 0;
		for (int i = 1; i < lists.size(); i++) {
			if (lists.get(i).peekFirst() < lists.get(min).peekFirst()) {
				min = i;
			}
		}
		return min;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(n*k).
}

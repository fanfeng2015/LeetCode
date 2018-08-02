package randomPickWithBlacklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// LeetCode #710 (Random Pick with Blacklist).

// Given a blacklist B containing unique integers from [0, N), write a function
// to return a uniform random integer from [0, N) which is NOT in B.

// Optimize it such that it minimizes the call to system’s Math.random().

// Notes:
// 1. <= N <= 1000000000
// 2. 0 <= B.length < min(100000, N)
// 3. [0, N) does NOT include N. See interval notation.

public class RandomPickWithBlacklist {

	// Solution 1: Create a white list. O(1) calls to Math.random().
	// Time complexity is O(N).
	// Space complexity is O(N).

	// Solution 2: for each element in [0, N - B.length), map the i-th black element
	// to the i-th white element in [N - B.length, N - 1].

	// N = 6, i.e., [0, 1, 2, 3, 4, 5]
	// B = [0, 2, 3]
	// 1. Let W = [3, 4, 5] - B = [4, 5]
	// 2. map = { 0: 4, 2: 5 }
	Map<Integer, Integer> map;
	int size; // sample size

	public RandomPickWithBlacklist(int N, int[] B) {
		map = new HashMap<>();
		size = N - B.length;
		Set<Integer> W = new HashSet<>();
		for (int i = size; i < N; i++) {
			W.add(i);
		}
		for (int x : B) {
			W.remove(x);
		}
		Iterator<Integer> iter = W.iterator();
		for (int x : B) {
			if (x < size) {
				map.put(x, iter.next());
			}
		}
	}

	public int pick() {
		int k = new Random().nextInt(size);
		return map.getOrDefault(k, k);
	}

	// Time complexity is O(N) for pre-processing, but O(1) thereafter.
	// Space complexity is O(N) for pre-processing, but O(B) thereafter.
	// O(1) calls to Math.random().
}

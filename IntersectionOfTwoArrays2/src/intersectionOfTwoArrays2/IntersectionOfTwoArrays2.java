package intersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #350

// Given two arrays, write a function to compute their intersection.

public class IntersectionOfTwoArrays2 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			Integer count = map.get(i);
			count = count == null ? 1 : count + 1;
			map.put(i, count);
		}
		List<Integer> list = new ArrayList<>();
		for (int i : nums2) {
			if (map.containsKey(i) && map.get(i) > 0) {
				list.add(i);
				map.put(i, map.get(i) - 1);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	// Time complexity is O(m+n).
	// Space complexity is O(m).
}

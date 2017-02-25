package intersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

// LeetCode #349

// Given two arrays, write a function to compute their intersection.

public class IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		Set<Integer> intersection = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersection.add(nums2[i]);
			}
		}
		int[] array = new int[intersection.size()];
		int index = 0;
		for (int num : intersection) {
			array[index++] = num;
		}
		return array;
	}

	// Time complexity is O(m+n).
	// Space complexity is O(m+n).
}

package twoSum;

import java.util.HashMap;
import java.util.Map;

// LeetCode #1 (Two Sum), #167 (Two Sum II - Input array is sorted).

// Given an array of integers, return indices of the two numbers such that they 
// add up to a specific target.

// You may assume that each input would have exactly one solution, and you may 
// not use the same element twice.

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				return new int[] { map.get(target - nums[i]), i };
			}
		}
		return new int[] { -1, -1 };
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Follow up: LeetCode #167 (Two Sum II - Input array is sorted).
	
	// Given an array of integers that is already sorted in ascending order,
	// find two numbers such that they add up to a specific target number.

	// The function twoSum should return indices of the two numbers such that
	// they add up to the target, where index 1 must be less than index 2.

	// Note:
	// 1. Your returned answers (both index 1 and index 2) are not zero-based.
	// 2. You may assume that each input would have exactly one solution and 
	// you may not use the same element twice.
	public int[] twoSum2(int[] array, int target) {
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == target) {
				return new int[] { left + 1, right + 1 };
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] { -1, -1 };
	}
}

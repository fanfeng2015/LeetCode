package containsDuplicate3;

import java.util.HashMap;
import java.util.Map;

// LeetCode #220

// Given an array of integers, find out whether there are two distinct indices
// i and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.

public class ContainsDuplicate3 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || t < 0) {
			return false;
		}
		int n = nums.length;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Long val = (long) nums[i] - Integer.MIN_VALUE;
			Long bucket = val / ((long) t + 1);
			if (map.containsKey(bucket) || map.containsKey(bucket - 1) && val - map.get(bucket - 1) <= t
					|| map.containsKey(bucket + 1) && map.get(bucket + 1) - val <= t) {
				return true;
			}
			if (map.entrySet().size() == k) {
				Long removeBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(removeBucket);
			}
			map.put(bucket, val);
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

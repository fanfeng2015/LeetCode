package summaryRanges;

import java.util.ArrayList;
import java.util.List;

// LeetCode #228

// Given a sorted integer array without duplicates, return the summary of its ranges.
// For example, given [0, 1, 2, 4, 5, 7], return ["0->2", "4->5", "7"].

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			int start = i;
			while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
				i++;
			}
			String str = (start == i) ? nums[start] + "" : nums[start] + "->" + nums[i];
			result.add(str);
			i++;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1)., ignoring space needed for output.
}

package containerWithMostWater;

// LeetCode #11

// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
// Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container and n is at least 2.

public class ContainerWithMostWater {

	// Solution 1: O(n^2) time, O(1) space
	public int maxArea(int[] height) {
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				min = Math.max(min, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return min;
	}

	// Solution 2:
	public int maxArea2(int[] height) {
		int max = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

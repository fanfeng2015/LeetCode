package maximumConsecutiveOnes2;

// Given a binary array, find the maximum number of consecutive 1s in this array 
// if you can flip at most one 0.

// Assumptions:
// 1. The input array will only contain 0 and 1.
// 2. The length of input array is a positive integer and will not exceed 10,000.

public class MaximumConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int zeros = 0, max = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            zeros = nums[right] == 0 ? zeros + 1 : zeros;
            while (zeros > 1) {
                zeros = nums[left++] == 0 ? zeros - 1 : zeros;
            }
            // guaranteed that range [left, right] contains exactly one 0
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    
    // Time complexity is O(n).
    // Space complexity is O(1).
}

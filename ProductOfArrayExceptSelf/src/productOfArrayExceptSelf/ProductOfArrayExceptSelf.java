package productOfArrayExceptSelf;

// LeetCode #238 (Product of Array Except Self).

// Given an array of n integers where n > 1, nums, return an array output
// such that output[i] is equal to the product of all the elements of nums 
// except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int prefixProduct = 1;
		for (int i = 0; i < n; i++) {
			result[i] = prefixProduct;
			prefixProduct *= nums[i];
		}
		int suffixProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= suffixProduct;
			suffixProduct *= nums[i];
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

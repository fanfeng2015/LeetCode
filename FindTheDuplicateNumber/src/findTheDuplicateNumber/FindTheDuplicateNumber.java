package findTheDuplicateNumber;

// LeetCode #287

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
// prove that at least one duplicate number must exist. 
// Assume that there is only one duplicate number, find the duplicate one.

// 1. You must not modify the array (assume the array is read only).
// 2 .You must use only constant, O(1) extra space.
// 3. Your runtime complexity should be less than O(n^2).
// 4. There is only one duplicate number in the array, but it could be repeated more than once.

public class FindTheDuplicateNumber {

	// This is an interesting problem.
	// Solution 1: use HashSet: O(n) time, O(n) space.

	// Solution 2: sort the input array first (for primitive types, Java uses
	// quick sort), then run binary search for each integer until the duplicate
	// number is found: O(n * log(n)) time, O(1) space.

	// Solution 3: the idea is the similar to finding the starting point of a
	// cycle in a linked list: O(n) time, O(1) space.

	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[fast];
			fast = nums[fast];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}

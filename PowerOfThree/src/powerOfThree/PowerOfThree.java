package powerOfThree;

// LeetCode #326 (Power of Three).

// Given an integer, write a function to determine if it is a power of three.

// Could you do it without using any loop / recursion?

public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
		return (n > 0 && 1162261467 % n == 0);
	}

}

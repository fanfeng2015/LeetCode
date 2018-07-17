package powerOfFour;

// LeetCode #342 (Power of Four).

// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

public class PowerOfFour {

	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

}

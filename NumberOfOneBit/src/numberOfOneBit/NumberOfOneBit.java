package numberOfOneBit;

// LeetCode #191

// Write a function that takes an unsigned integer and 
// returns the number of '1' bits it has.

public class NumberOfOneBit {

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}

}
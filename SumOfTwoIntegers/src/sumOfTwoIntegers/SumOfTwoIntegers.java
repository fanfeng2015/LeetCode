package sumOfTwoIntegers;

// LeetCode #371

// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

public class SumOfTwoIntegers {

	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		}
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
}

package addBinary;

// LeetCode #67

// Given two binary strings, return their sum (also a binary string).

public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			carry += (i >= 0) ? a.charAt(i--) - '0' : 0;
			carry += (j >= 0) ? b.charAt(j--) - '0' : 0;
			sb.append(carry % 2);
			carry /= 2;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

	// Time complexity is O(m+n).
	// Space complexity is O(1), ignoring space needed for output.
}
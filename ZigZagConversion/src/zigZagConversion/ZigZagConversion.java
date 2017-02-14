package zigZagConversion;

// LeetCode #6

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
// as "PAHNAPLSIIGYIR".

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sbs[i] = new StringBuilder();
		}
		boolean downwards = true;
		int index = 0; // indicates which line
		for (int i = 0; i < s.length(); i++) {
			sbs[index].append(s.charAt(i));
			if (index == 0) {
				downwards = true;
				index++;
			} else if (index == numRows - 1) {
				downwards = false;
				index--;
			} else {
				index = downwards ? index + 1 : index - 1;
			}
		}
		for (int i = 1; i < numRows; i++) {
			sbs[0].append(sbs[i]);
		}
		return sbs[0].toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

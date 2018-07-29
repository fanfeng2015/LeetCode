package zigZagConversion;

// LeetCode #6 (Zig Zag Conversion).

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
		int line = 0; // indicates line
		for (int i = 0; i < s.length(); i++) {
			sbs[line].append(s.charAt(i));
			if (line == 0) {
				downwards = true;
				line++;
			} else if (line == numRows - 1) {
				downwards = false;
				line--;
			} else {
				line = downwards ? line + 1 : line - 1;
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

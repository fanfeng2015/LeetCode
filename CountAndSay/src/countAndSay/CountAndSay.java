package countAndSay;

// LeetCode #38

// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

public class CountAndSay {

	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for (int i = 1; i < n; i++) {
			String s = sb.toString();
			sb = new StringBuilder();
			int index = 0, count = 1;
			while (index < s.length()) {
				while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
					count++;
					index++;
				}
				sb.append(count).append(s.charAt(index));
				index++;
				count = 1;
			}
		}
		return sb.toString();
	}
}
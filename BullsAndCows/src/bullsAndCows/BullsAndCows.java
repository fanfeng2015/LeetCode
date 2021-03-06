package bullsAndCows;

// LeetCode #299

public class BullsAndCows {

	// Solution 1: two passes
	// Assumption: secret and guess don't need to have the same length
	public String getHint(String secret, String guess) {
		int[] countMap = new int[10];
		int bulls = 0, cows = 0;
		int m = secret.length(), n = guess.length();
		for (int i = 0; i < m; i++) {
			if (i < n && secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				countMap[Character.getNumericValue(secret.charAt(i))]++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i < m && guess.charAt(i) == secret.charAt(i)) {
				continue;
			}
			if (countMap[Character.getNumericValue(guess.charAt(i))] > 0) {
				cows++;
				countMap[Character.getNumericValue(guess.charAt(i))]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

	// Time complexity is O(m+n).
	// Space complexity is O(1).

	// Solution 2: one pass
	// Assumption: secret and guess have the same length
	public String getHint2(String secret, String guess) {
		int[] countMap = new int[10];
		int bulls = 0, cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			int m = Character.getNumericValue(secret.charAt(i));
			int n = Character.getNumericValue(guess.charAt(i));
			if (m == n) {
				bulls++;
			} else {
				if (countMap[m] < 0) {
					cows++;
				}
				if (countMap[n] > 0) {
					cows++;
				}
				countMap[m]++;
				countMap[n]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

	// Time complexity is O(m+n).
	// Space complexity is O(1).
}

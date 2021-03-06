package canIWin;

import java.util.HashMap;

// LeetCode #464

public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= 0) {
			return true;
		}
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
			return false;
		}
		return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<Integer, Boolean>());
	}

	private boolean canIWin(int maxChoosableInteger, int desiredTotal, int used, HashMap<Integer, Boolean> map) {
		if (map.containsKey(used)) {
			return map.get(used);
		}
		for (int i = 0; i < maxChoosableInteger; i++) {
			if ((used & (1 << i)) != 0) {
				continue;
			}
			// can pick number i + 1
			if (desiredTotal <= i + 1 || !canIWin(maxChoosableInteger, desiredTotal - (i + 1), used ^ (1 << i), map)) {
				map.put(used, true);
				return true;
			}
		}
		map.put(used, false);
		return false;
	}

	// Let n be maxChoosableInteger.
	// Time complexity is O(2^n).
	// Space complexity is O(2^n).
}

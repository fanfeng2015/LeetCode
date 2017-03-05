package firstBadVersion;

// LeetCode #278

public class FirstBadVersion extends VersionControl {

	public int firstBadVersion(int n) {
		int left = 1, right = n;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return isBadVersion(left) ? left : right;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

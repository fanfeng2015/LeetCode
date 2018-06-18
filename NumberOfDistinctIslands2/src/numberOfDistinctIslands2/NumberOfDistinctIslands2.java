package numberOfDistinctIslands2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #711 (Number of Distinct Islands II).

public class NumberOfDistinctIslands2 {

	public int numDistinctIslands(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					List<Integer> coordinates = new ArrayList<>();
					DFS(grid, i, j, coordinates);
					if (set.add(canonical(coordinates))) {
						count++;
					}
				}
			}
		}
	}

}

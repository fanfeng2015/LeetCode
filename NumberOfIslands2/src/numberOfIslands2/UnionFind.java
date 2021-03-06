package numberOfIslands2;

public class UnionFind {
	
	private int m;
	private int n;
	private int[] parent; // parent of i
	private int[] size; // size of the tree rooted at i
	
	private int count; // number of components
	
	public UnionFind(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		parent = new int[m * n];
		size = new int[m * n];
		// Note: there is no '1' in the grid initially.
	}
	
	public int count() {
		return count;
	}
	
	// add land operation
	public void add(int row, int col) {
		int index = row * n + col;
		parent[index] = index;
		size[index] = 1;
		count++;
	}
	
	public int find(int p) {
		validate(p);
		int root = p;
		while (root != parent[root]) {
			root = parent[root];
		}
		while (p != root) { // path compression to make tree flat
			int newParent = parent[root];
			parent[p] = root;
			p = newParent;
		}
		return root;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void union(int p, int q) {
		int parentP = find(p);
		int parentQ = find(q);
		if (parentP == parentQ) {
			return;
		}
		// weighted quick union by size: make smaller root point to larger root
		if (size[parentP] < size[parentQ]) {
			parent[parentP] = parentQ;
			size[parentQ] += size[parentP];
		}
		else {
			parent[parentQ] = parentP;
			size[parentP] += size[parentQ];
		}
		count--;
	}
	
	private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
		}
	}
	
	// Time complexity is O((m+n) * log(n)), on any m union-find operations
	// on a set of n objects.
}

package invertBinaryTree;

import java.util.LinkedList;

// LeetCode #226

public class InvertBinaryTree {

	// Solution 1: recursive solution
	public TreeNode invertTree(TreeNode root) {
		// base case
		if (root == null) {
			return root;
		}
		// recursive rule
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: iterative solution
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollLast();
			// swap left and right
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null) {
				queue.offerFirst(node.left);
			}
			if (node.right != null) {
				queue.offerFirst(node.right);
			}
		}
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

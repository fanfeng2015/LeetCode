package lowestCommonAncestorOfBST;

// LeetCode #235
// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// Assumption: 
// 1. root is not null.
// 2. p and q are guaranteed to be in the BST.

public class LowestCommonAncestorOfBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	// Time complexity is O(n), when the BST is highly unbalanced, and p and q
	// are far away from root.
	// Space complexity is O(1).
}

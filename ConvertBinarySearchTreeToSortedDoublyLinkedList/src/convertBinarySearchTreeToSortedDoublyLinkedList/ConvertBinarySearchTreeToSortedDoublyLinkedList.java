package convertBinarySearchTreeToSortedDoublyLinkedList;

import java.util.Stack;

// LeetCode #426 (Convert Binary Search Tree to Sorted Doubly Linked List).

// Convert a BST to a sorted circular doubly-linked list in-place. Think of the left
// and right pointers as synonymous to the previous and next pointers in a doubly-linked 
// list.

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

	// recursive
	TreeNode prev = null;

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode head = new TreeNode(0);
		prev = head;
		helper(root);
		// connect head and tail
		prev.right = dummy.right;
		dummy.right.left = prev;
		return dummy.right;
	}

	private void helper(TreeNode cur) {
		if (cur == null) {
			return;
		}
		helper(cur.left);
		prev.right = cur;
		cur.left = prev;
		prev = cur;
		helper(cur.right);
	}

	// iterative in-order
	public TreeNode treeToDoublyList2(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root, prev = null;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				TreeNode right = cur.right; // temporary node since cur.right might change
				cur.left = prev;
				TreeNode smallest = findSmallest(cur.right); // not optimal
				cur.right = (smallest == null && stack.size() > 0) ? stack.peek() : smallest;
				prev = cur;
				cur = right;
			}
		}
		// prev is the right most node now
		TreeNode left = root;
		while (left.left != null) {
			left = left.left;
		}
		left.left = prev;
		prev.right = left;
		return left;
	}

	private TreeNode findSmallest(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

}

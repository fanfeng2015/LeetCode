package serializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;

// LeetCode #297 (Serialize and Deserialize Binary Tree).
// LeetCode #449 (Serialize and Deserialize BST).

// Design an algorithm to serialize and deserialize a binary tree. 

// There is no restriction on how your serialization / deserialization algorithm should work. 

// You just need to ensure that a binary tree can be serialized to a string and this string can
// be deserialized to the original tree structure.

public class SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return serialize(new StringBuilder(), root).toString();
	}

	private StringBuilder serialize(StringBuilder sb, TreeNode root) {
		if (root == null) {
			return sb.append("#");
		}
		sb.append(root.val).append(",");
		serialize(sb, root.left).append(",");
		serialize(sb, root.right);
		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	private TreeNode deserialize(LinkedList<String> data) {
		String val = data.pollFirst();
		if ("#".equals(val)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = deserialize(data);
		root.right = deserialize(data);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if binary tree is highly unbalanced.
}

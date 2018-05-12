package binaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #107 (Binary Tree Level Order Traversal II).

public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollLast();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
            result.offerFirst(curLevel);
        }
        return result;  
    }
    
 	// Time complexity is O(n).
 	// Space complexity is O(n).	
}

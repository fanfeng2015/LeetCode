package pathSum4;

import java.util.HashMap;
import java.util.Map;

// LeetCode #666 (Path Sum 4).

// If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

// For each integer in this list:
// The hundreds digit represents the depth D of this node, 1 <= D <= 4.
// The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
// The units digit represents the value V of this node, 0 <= V <= 9.

// Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

public class PathSum4 {

    private int soFar = 0;
    private int result = 0;
    
    public int pathSum(int[] nums) {
        Map<Integer, Integer> tree = representTree(nums);
        DFS(nums[0] / 10, tree);
        return result;
    }
    
    private Map<Integer, Integer> representTree(int[] nums) {
        Map<Integer, Integer> tree = new HashMap<>();
        for (int node : nums) {
            tree.put(node / 10, node % 10);
        }
        return tree;
    }
    
    private void DFS(int root, Map<Integer, Integer> tree) {
        soFar += tree.get(root);
        int left = (root / 10 + 1) * 10 + (2 * (root % 10) - 1);
        int right = (root / 10 + 1) * 10 + (2 * (root % 10));
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            result += soFar;
        }
        if (tree.containsKey(left)) {
            DFS(left, tree);
        }
        if (tree.containsKey(right)) {
            DFS(right, tree);
        }
        soFar -= tree.get(root);
    }
    
    // Time complexity is O(n).
    // Space complexity is O(n).	
}

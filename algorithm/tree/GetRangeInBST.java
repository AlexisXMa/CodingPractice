package algorithm.tree;

/*
Get the list of keys in a given binary search tree in a given range[min, max]
in ascending order, both min and max are inclusive.
 */

import java.util.ArrayList;
import java.util.List;

public class GetRangeInBST {
    // Time = O(n)
    // Space = O(height)
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    public void getRange(TreeNode root, int min, int max, List<Integer> list){
        if (root == null) {
            return;
        }
        // 1. determine if left subtree should be traversed only when root.key > min
        if (root.key > min) {
            getRange(root.left, min, max, list);
        }
        // 2. determine if root should be traversed
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        // 3. determine if right subtree should be traversed only when root.key < max
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
    }
}

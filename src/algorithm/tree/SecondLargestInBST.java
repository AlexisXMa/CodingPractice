package algorithm.tree;

/*
Find the second largest key in the given binary search tree.
If there does not exist the second largest key, return Integer.MIN_VALUE.

Assumptions:
The given binary search tree is not null.
 */

public class SecondLargestInBST {
    // Time = O(h); Space = O(1)
    public int secondLargest(TreeNode root) {
        int[] result = new int[]{ Integer.MIN_VALUE };
        if (root == null || (root.left == null && root.right == null)) {
            return result[0];
        }
        TreeNode prev = null;
        while (root.right != null) {
            prev = root;
            root = root.right;
        }
        if (root.left == null) {
            return prev.key;
        }
        return findLargest(root.left);
    }

    private int findLargest(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.key;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }
}

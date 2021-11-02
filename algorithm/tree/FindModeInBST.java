package algorithm.tree;

// 501. Find Mode in Binary Search Tree

import java.util.*;

public class FindModeInBST {
    // Method: Recursion
    private TreeNode prev;
    private int count = 0;
    private int maxCount = -1;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        prev = root;
        inorder(root, modes);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) {
            return;
        }

        inorder(root.left, modes);

        count = prev.key == root.key ? count + 1 : 1;
        if (count == maxCount) {
            modes.add(root.key);
        } else if (count > maxCount) {
            modes.clear();
            modes.add(root.key);
            maxCount = count;
        }

        prev = root;

        inorder(root.right, modes);
    }
}

package algorithm.tree;

/*
In a binary tree, two nodes are cousins of each other if they are at the same level and have different parents.
Given a binary tree and two nodes, determine if the two nodes are cousins or not.
 */

import java.util.*;

public class IsCousin {
    public boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode pa = null;
        TreeNode pb = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    if (cur.left == a) {
                        pa = cur;
                    } else if (cur.left == b) {
                        pb = cur;
                    }
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    if (cur.right == a) {
                        pa = cur;
                    } else if (cur.right == b) {
                        pb = cur;
                    }
                    queue.offer(cur.right);
                }
            }
            // make sure that a and b are in the same level with different parent
            if (pa != null && pb != null) {
                return pa != pb;
            }
            if (pa != null || pb != null) {
                return false;
            }
        }
        return false;
    }

}

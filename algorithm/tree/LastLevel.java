package algorithm.tree;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values,
from left to right. Only need to return lowest level.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LastLevel {
    public List<Integer> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            level.clear();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return level;
    }
}

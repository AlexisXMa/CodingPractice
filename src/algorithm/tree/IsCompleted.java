package algorithm.tree;

/*
Check if a given binary tree is completed.
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class IsCompleted {
    // Time = O(n)
    // Space = O(n)
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        // if the flag is set true, there should not be any child nodes afterwards
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if  (cur.left != null && flag == true) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if  (cur.right != null && flag == true) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}

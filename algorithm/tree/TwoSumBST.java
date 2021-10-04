package algorithm.tree;

import java.util.*;

public class TwoSumBST {
    // Method 2: BFS(level traversal) + HashSet
    public boolean twoSumBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (set.contains(target - cur.key)) {
                    return true;
                }
                set.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return false;
    }
}

package algorithm.tree;

/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelTraversalZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int levelNum = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (levelNum % 2 == 1) {
                    // At odd level, from left to right to expand.
                    TreeNode cur = deque.pollFirst();
                    result.add(cur.key);
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    // At even level, from right to left to expand.
                    TreeNode cur = deque.pollLast();
                    result.add(cur.key);
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            }
            levelNum++;
        }
        return result;
    }
}

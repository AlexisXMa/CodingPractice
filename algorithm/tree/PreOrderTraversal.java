package algorithm.tree;

/*
pre-order traversal of a given binary tree, return the list of keys of
each node in the tree as it is pre-order traversed.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderTraversal {
    // Iterative Method:
    // Time = O(n), n == tree size
    // Space = O(height)
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            // the left subtree should be traversed before the right subtree
            // since the stack is LIFO, we should push right into the stack first
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);
        }
        return preorder;
    }
}

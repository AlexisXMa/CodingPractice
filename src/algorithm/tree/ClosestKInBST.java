package algorithm.tree;

/*
In a binary search tree, find k nodes containing the closest numbers to the given target number.
Return them in sorted array.

Assumptions:
The given root is not null.
There are no duplicate keys in the binary search tree.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosestKInBST {
    // Method: inOrder traversal + sliding window of size k (deque)
    // Time = O(n); Space = O(k)
    public int[] closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        helper(root, target, k, deque);
        int size = deque.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = deque.pollFirst().key;
        }
        return result;
    }

    private void helper(TreeNode root, double target, int k, Deque<TreeNode> deque) {
        if (root == null) {
            return;
        }
        helper(root.left, target, k, deque);
        if (deque.size() < k) {
            deque.offerLast(root);
        } else {
            if (Math.abs(root.key - target) < Math.abs(deque.peekFirst().key - target)) {
                deque.pollFirst();
                deque.offerLast(root);
            }
        }
        helper(root.right, target, k, deque);
    }
}

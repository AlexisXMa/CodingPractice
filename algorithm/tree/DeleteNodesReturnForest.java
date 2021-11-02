package algorithm.tree;

// 1110. Delete Nodes And Return Forest

import java.util.*;

public class DeleteNodesReturnForest {
    // Method: Recursion
    // Time = O(n); Space = O(n)
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Set<Integer> deleteSet = new HashSet<>();
        for (int node: to_delete) {
            deleteSet.add(node);
        }

        helper(root, deleteSet, result);
        if (!deleteSet.contains(root.key)) {
            result.add(root);
        }
        return result;
    }


    private TreeNode helper(TreeNode node, Set<Integer> deleteSet, List<TreeNode> result) {
        if (node == null) {
            return null;
        }

        node.left = helper(node.left, deleteSet, result);
        node.right = helper(node.right, deleteSet, result);

        if (deleteSet.contains(node.key)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null;
        }

        return node;
    }
}

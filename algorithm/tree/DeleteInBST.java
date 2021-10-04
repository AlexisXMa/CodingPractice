package algorithm.tree;

/*
Delete the target key K in the given binary search tree if the binary search tree contains K.
Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree,
after deletion the binary search tree's property should be maintained.
 */

public class DeleteInBST {
    // Time = O(height) - worst case, O(n); for balanced BST, O(logn)
    // Space = O(height)
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                } else {
                    TreeNode newRoot = deleteSmallest(root.right);
                    newRoot.left = root.left;
                    newRoot.right = root.right;
                    return newRoot;
                }
            }
        }

        // find the target node
        if (key < root.key) {
            root.left = deleteTree(root.left, key);
        } else if (key > root.key) {
            root.right = deleteTree(root.right, key);
        }
        return root;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }
}

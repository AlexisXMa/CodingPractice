package algorithm.tree;

// 951. Flip Equivalent Binary Trees

public class FlipEquivalentBinaryTrees {
    // Method: Recursion
    // Time = O(n); Space = O(h)
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.key != root2.key) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}

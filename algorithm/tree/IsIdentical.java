package algorithm.tree;

/*
Check if two given binary trees are identical.
Identical means the equal valued keys are at the same position in the two binary trees.
 */

public class IsIdentical {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
    }
}

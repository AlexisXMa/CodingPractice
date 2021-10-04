package algorithm.tree;

/*
Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed.
A tweak is defined as a swap of the children of one node in the tree.
 */

public class IsTweakedIdentical {
    // Time = O(n^2)
    // Space = O(height)
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
                || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
}

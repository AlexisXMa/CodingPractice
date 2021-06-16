package algorithm.tree;

/*
In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:
The given root is not null.
There are no duplicate keys in the binary search tree.
 */

/*
Data structure: int result      // to record the result TreeNode's key
Algorithm:
  1. Iteratively go through the tree from top to bottom
  2. if (root.key == target)
      return root.key
  3. else if (root.key < target)
      update result if (|target - root.key| < |target - result|)
      go to right subtree
  4. else
      update result if (|target - root.key| < |target - result|)
      go to left subtree
  5. return the result when it hits the bottom of the tree
 Time = O(h); worst O(n); Average O(log n)
 Space = O(1)
 */

public class ClosestInBST {
    public int closest(TreeNode root, int target) {
        // Assumption: given root is not null
        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            } else if (root.key < target) {
                if (Math.abs(target - root.key) < Math.abs(target - result)) {
                    result = root.key;
                }
                root = root.right;
            } else {
                if (Math.abs(target - root.key) < Math.abs(target - result)) {
                    result = root.key;
                }
                root = root.left;
            }
        }
        return result;
    }
}

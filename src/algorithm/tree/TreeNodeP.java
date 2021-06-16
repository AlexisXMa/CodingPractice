package algorithm.tree;

/*
TreeNode in a binary tree with parent pointer available.
 */

public class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;
    public TreeNodeP(int key, TreeNodeP parent) {
      this.key = key;
      this.parent = parent;
    }
}

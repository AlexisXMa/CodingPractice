package algorithm.tree;

// 437. Path Sum III

public class PathSumIII {
    // Method: DFS - Recursion
    // Time = O(n^2); Space = O(n)
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode node, int target) {
        if (node == null) {
            return 0;
        }
        return (node.key == target ? 1 : 0) + dfs(node.left, target - node.key) + dfs(node.right, target - node.key);
    }
}

package algorithm.search;

// 695. Max Area of Island

public class MaxAreaOfIsland {
    // Method: DFS
    // grid = m rows by n cols
    // Time = O(mn) for visiting every square
    // Space = O(mn)
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int curArea = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Check whether the current square (grid[r][c]) is valid
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
            grid[r][c] = 2;
            return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
        }
        return 0;
    }
}

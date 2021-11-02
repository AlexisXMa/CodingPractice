package algorithm.dp;

// 562. Longest Line of Consecutive One in Matrix

public class LongestLineOfConsecutiveOneInMatrix {
    // Method: DP
    // Time = O(mn); Space = O(mn)
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][][]dp = new int[m][n][4];
        int max = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    dp[r][c][k] = 1;
                }
                // Vertical direction
                if (r > 0) {
                    dp[r][c][0] += dp[r - 1][c][0];
                }
                // Horizontal direction
                if (c > 0) {
                    dp[r][c][1] +=  dp[r][c - 1][1];
                }
                // Diagonal direction
                if (r > 0 && c > 0) {
                    dp[r][c][2] +=  dp[r - 1][c - 1][2];
                }
                // Anti-diagonal direction
                if (r > 0 && c < n - 1) {
                    dp[r][c][3] +=  dp[r - 1][c + 1][3];
                }
                // Update the max if applicable
                max = Math.max(max, Math.max(dp[r][c][0], dp[r][c][1]));
                max = Math.max(max, Math.max(dp[r][c][2], dp[r][c][3]));
            }
        }
        return max;
    }
}

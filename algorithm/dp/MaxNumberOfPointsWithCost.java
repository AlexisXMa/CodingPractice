package algorithm.dp;

// 1937. Maximum Number of Points with Cost

public class MaxNumberOfPointsWithCost {
    // Method: DP
    // Time = O(mn); Space = O(n)
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[c] += points[r][c];
            }
            for (int c = 1; c < n; c++) {
                dp[c] = Math.max(dp[c], dp[c - 1] - 1);
            }
            for (int c = n - 2; c >= 0; c--) {
                dp[c] = Math.max(dp[c], dp[c + 1] - 1);
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

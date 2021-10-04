package design;

// 304. Range Sum Query 2D - Immutable

public class RangeSumQuery {
    // Method: 2D dp
    // Time = O(1) pre query, O(mn) for pre-computation
    // Space = O(mn) to store the cumulative region sum

    private int[][] dp;

    public RangeSumQuery(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows + 1][cols + 1];

        // dp[i + 1][j + 1] = cumulative region sum of matrix(i, j)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    // Sum(ABCD) = Sum(OD) − Sum(OB) − Sum(OC) +Sum(OA)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}

package algorithm.dp;

// 1277. Count Square Submatrices with All Ones

public class CountSquaresWithAllOnes {
    // Method: DP
    // Time = O(mn); Space = O(1)
    public int countSquares(int[][] matrix) {
        int result = 0;
        // dp[i][j] := the number of squares with matrix[i][j] as bottom-right corner.
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r > 0 && c > 0 && matrix[r][c] == 1) {
                    matrix[r][c] = Math.min(matrix[r - 1][c - 1], Math.min(matrix[r - 1][c], matrix[r][c - 1])) + 1;
                }
                result += matrix[r][c];
            }
        }
        return result;
    }
}

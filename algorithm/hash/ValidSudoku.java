package algorithm.hash;

// 36. Valid Sudoku

public class ValidSudoku {
    // Method: Array as Map
    // Time = O(n^2); Space = O(n^2)
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use 2D arrays to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row status
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column status
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box status
                int boxR = r / 3;
                int boxC = c / 3;
                int boxIdx = boxR * 3 + boxC;
                if (boxes[boxIdx][pos] == 1) {
                    return false;
                }
                boxes[boxIdx][pos] = 1;
            }
        }
        return true;
    }


    // Method: Bit-Masking
    // Time = O(n^2); Space = O(n)
    public boolean isValidSudoku2(char[][] board) {
        int N = 9;

        // Use array to record the status
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                int pos = 1 << (val - 1);

                // Check the row status
                if ((rows[r] & pos) > 0) {
                    return false;
                }
                rows[r] |= pos;

                // Check the column status
                if ((cols[c] & pos) > 0) {
                    return false;
                }
                cols[c] |= pos;

                // Check the box status
                int boxR = r / 3;
                int boxC = c / 3;
                int boxIdx = boxR * 3 + boxC;
                if ((boxes[boxIdx] & pos) > 0) {
                    return false;
                }
                boxes[boxIdx] |= pos;
            }
        }
        return true;
    }
}

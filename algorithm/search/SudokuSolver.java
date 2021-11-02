package algorithm.search;

// 37. Sudoku Solver

public class SudokuSolver {
    // Method: DFS
    // m = n = 9
    // Time = O(9^(m * n))
    // Space = O(m * n)

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int N = 9;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') {
                    // Try digit from 1 to 9
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, r, c, digit)) {
                            board[r][c] = digit;

                            // If Sudoku is solved, return true
                            if (solve(board)) return true;
                                // Otherwise, set back to original
                            else board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        int N = 9;
        for (int idx = 0; idx < 9; idx++) {
            // check row status
            if (board[row][idx] == digit) {
                return false;
            }

            // check column status
            if (board[idx][col] == digit) {
                return false;
            }

            // check box status
            int boxR = (row / 3) * 3 + idx / 3;
            int boxC = (col / 3) * 3 + idx % 3;
            if (board[boxR][boxC] == digit) {
                return false;
            }
        }
        return true;
    }
}

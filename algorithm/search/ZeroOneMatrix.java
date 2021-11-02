package algorithm.search;

// 542. 01 Matrix

import java.util.*;

public class ZeroOneMatrix {
    // Method: BFS
    // matrix: m rows by n cols
    // Time = O(mn)
    // Space = O(mn) to maintain the queue
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    queue.offer(new int[]{ r, c });
                } else {
                    matrix[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d: dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                queue.add(new int[]{ r, c });
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}

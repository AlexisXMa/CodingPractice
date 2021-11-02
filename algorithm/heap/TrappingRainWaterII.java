package algorithm.heap;

// 407. Trapping Rain Water II

import java.util.*;

public class TrappingRainWaterII {
    static class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // First, add all the Cells on the borders to the pq.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        // Pick the shortest cell visited and check its neighbors.
        // If the neighbor is shorter, collect the water it can trap and
        // update its height as its height plus the water trapped.
        // Add all its neighbors to the pq.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] d: dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    result += Math.max(0, cell.height - heightMap[r][c]);
                    pq.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
                }
            }
        }
        return result;
    }
}

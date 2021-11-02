package algorithm.search;

// 1293. Shortest Path in a Grid with Obstacles Elimination

import java.util.*;

public class ShortestPathWithObstaclesElimination {
    // Method: BFS
    // Time = O(mnk); Space = O(mnk)
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0});

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curR = cur[0];
                int curC = cur[1];
                int curK = cur[2];
                if (curR == rows - 1 && curC == cols - 1) {
                    return result;
                }
                for (int[] d: dirs) {
                    int nextR = curR + d[0];
                    int nextC = curC + d[1];
                    int nextK = curK;
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols) {
                        if (grid[nextR][nextC] == 1) {
                            nextK++;
                        }
                        if (nextK <= k && !visited[nextR][nextC][nextK]) {
                            visited[nextR][nextC][nextK] = true;
                            queue.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}

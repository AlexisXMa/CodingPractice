package algorithm.math;

// 593. Valid Square

import java.util.*;

public class ValidSquare {
    // Method: Sorting
    // Time = O(log 4) = O(1)
    // Space = O(1)
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        return distance(points[0], points[1]) != 0
                && distance(points[0], points[1]) == distance(points[1], points[3])
                && distance(points[1], points[3]) == distance(points[3], points[2])
                && distance(points[3], points[2]) == distance(points[2], points[0])
                && distance(points[0], points[3]) == distance(points[1], points[2]);
    }

    private double distance(int[] a, int[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }
}

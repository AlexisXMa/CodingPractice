package algorithm.array;

// 986. Interval List Intersections

import java.util.*;

public class IntervalListIntersections {
    // Method: Merge Intervals
    // m = length of A, n = length of B
    // Time = O(m + n)
    // Space = O(m + n)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int firstIdx = 0;
        int secondIdx = 0;
        while (firstIdx < firstList.length && secondIdx < secondList.length) {
            // Check if A[i] intersects B[j]
            // low - the startpoint of the intersection
            // high - the endpoint of the intersection
            int low = Math.max(firstList[firstIdx][0], secondList[secondIdx][0]);
            int high = Math.min(firstList[firstIdx][1], secondList[secondIdx][1]);
            if (low <= high) {
                result.add(new int[]{ low, high });
            }

            // Remove the interval with the smaller endpoint
            if (firstList[firstIdx][1] < secondList[secondIdx][1]) {
                firstIdx++;
            } else {
                secondIdx++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

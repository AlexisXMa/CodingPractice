package algorithm.heap;

// 1499. Max Value of Equation

import javafx.util.*;
import java.util.*;

public class MaxValueOfEquation {
    // Method: maxHeap
    // Time = O(n log n)
    // Space = O(n)
    public int findMaxValueOfEquation(int[][] points, int k) {
        // maxHeap stores pairs: <key: y - x, value: x>
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getKey() - a.getKey()));
        int max = Integer.MIN_VALUE;
        for (int[] point: points) {
            while (!maxHeap.isEmpty() && point[0] - maxHeap.peek().getValue() > k) {
                maxHeap.poll();
            }
            if (!maxHeap.isEmpty()) {
                // yi+yj+|xi-xj| => (xj+yj)+(yi-xi)
                max = Math.max(max, point[0] + point[1] + maxHeap.peek().getKey());
            }
            maxHeap.offer(new Pair<Integer, Integer>(point[1] - point[0], point[0]));
        }
        return max;
    }
}

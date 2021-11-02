package algorithm.queueAndStack;

// 1776. Car Fleet II

import java.util.*;

public class CarFleetII {
    // Method: Stack
    // Time = O(n); Space = O(n)
    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        Arrays.fill(result, -1.0);

        // Use stack to store collision candidates
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            int[] c1 = cars[i];
            int p1 = c1[0];
            int s1 = c1[1];
            while (!stack.isEmpty()) {
                int j = stack.peekLast();
                int[] c2 = cars[j];
                int p2 = c2[0];
                int s2 = c2[1];
                double curCollisionTime = 1.0 * (p2 - p1) / (s1 - s2);
                if (s1 <= s2 || curCollisionTime >= result[j] && result[j] > 0) {
                    stack.pollLast();
                } else {
                    result[i] = curCollisionTime;
                    break;
                }
            }
            stack.offerLast(i);
        }
        return result;
    }
}

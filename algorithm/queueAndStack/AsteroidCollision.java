package algorithm.queueAndStack;

// 735. Asteroid Collision

import java.util.*;

public class AsteroidCollision {
    // Method: Stack
    // Time = O(n); Space = O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i: asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0
                        && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                } else if (stack.peek() + i == 0) {
                    // If both are the same size, both will explode.
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

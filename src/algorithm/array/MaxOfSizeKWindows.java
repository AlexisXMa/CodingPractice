package algorithm.array;

/*
Given an integer array A and a sliding window of size K,
find the maximum value of each window as it slides from left to right.

Assumptions:
1. The given array is not null and is not empty
2. K >= 1, K <= A.length
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxOfSizeKWindows {
    // Time = O(n); Space = O(k)
    public List<Integer> maxWindows(int[] array, int k) {
        // Assumptions: 1. array is not null or empty
        // 2. 1 <= k <= array.length
        List<Integer> result = new ArrayList<>();
        // Use a descending deque to solve this problem,
        // we store the index instead of the actual value in the deque, and make sure:
        // 1. the deque only contains index i in the current sliding window.
        // 2. for any index, the previous index with smaller value is discarded from the deque.
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            // Discard any index with smaller value than index i
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            // If the head element is out of the current sliding window, we discard it as well.
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Add the new entering element.
            deque.offerLast(i);
            // Pop the new exiting element.
            if (i >= k - 1) {
                result.add(array[deque.peekFirst()]);
            }
        }
        return result;
    }
}

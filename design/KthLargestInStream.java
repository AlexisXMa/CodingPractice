package design;

// 703. Kth Largest Element in a Stream

import java.util.*;

public class KthLargestInStream {
    // Method: minHeap of size k
    // n = length of nums, m = number of add() operations
    // Time = O((n + m) log k)
    // Space = O(k)

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

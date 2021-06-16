package algorithm.heap;

/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SmallestK {
    // Method 1: max-heap of size k
    // Time = O(k + (n-k)log(k))
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }


    // Method 2: quick select
    // Time = O(n) on average; O(n^2) worst case
    public int[] kSmallest2(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k - 1);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private void quickSelect(int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (mid == target) {
            return;
        } else if (target < mid) {
            // need to recursively call quick select on the left partition
            // if the k-th smallest one is in the left partition
            quickSelect(array, left, mid - 1, target);
        } else {
            // need to recursively call quick select on the right partition
            // if the k-th smallest one is in the right partition
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] >= pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    // Method 3: min-Heap
    // Time = O(n + k log n).
    // In this coding method, Time = O(n log n + k log n).
    public int[] kSmallest3(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

}

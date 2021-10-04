package algorithm.array;

// 347. Top K Frequent Elements

import java.util.*;

public class TopKFrequentElements {
    // Method: Min-heap of size k
    // Time = O(n log k) for Min-heap of size k operations
    // Space = O(n) for HashMap
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countFreq = new HashMap<>();
        for(Integer num: nums) {
            countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            if (countFreq.get(a) == countFreq.get(b)) {
                return 0;
            }
            return countFreq.get(a) < countFreq.get(b) ? -1 : 1;
        });
        for (Integer num: countFreq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }


    // Method: Bucket Sort
    // Time = O(n); Space = O(n)
    public int[] topKFrequent2(int[] nums, int k) {
        // Construct a frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Bucket sort on frequencies
        // Bucket stores <Frequency: <Element List>>
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int key: map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        // Adding top k elements from right to left
        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            resultList.addAll(buckets[i]);
            if (resultList.size() >= k) {
                break;
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

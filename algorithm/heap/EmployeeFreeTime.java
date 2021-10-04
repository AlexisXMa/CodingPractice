package algorithm.heap;

// 759. Employee Free Time

import java.util.*;

public class EmployeeFreeTime {
    // Method: PriorityQueue
    // Time = O(n log n)
    // Space = O(n)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));

        for (List<Interval> person: schedule) {
            for (Interval interval: person) {
                minHeap.offer(interval);
            }
        }

        Interval curr = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Interval next = minHeap.peek();
            if (curr.end < next.start) {
                result.add(new Interval(curr.end, next.start));
                curr = minHeap.poll();
            } else {
                curr.end = Math.max(curr.end, next.end);
                minHeap.poll();
            }
        }
        return result;
    }
}

package algorithm.queueAndStack;

// 636. Exclusive Time of Functions

import java.util.*;

public class ExclusiveTimeOfFunctions {
    // Method: Stack
    // Time = O(n)
    // Space = O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // preTime := the start of the interval
        int preTime = 0;
        for (String log: logs) {
            String[] curLog = log.split(":");
            int curId = Integer.valueOf(curLog[0]);
            String status = curLog[1];
            int curTime = Integer.valueOf(curLog[2]);
            if (status.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curTime - preTime;
                }
                // curTime is the start of the next interval and does not
                // belong to the current interval
                stack.push(curId);
                preTime = curTime;
            } else {
                // curTime is the end of the current interval and belongs to
                // the current interval, so we need to +1 here
                result[stack.pop()] += curTime - preTime + 1;
                // preTime here means the start of next interval, so we also
                // need to +1
                preTime = curTime + 1;
            }
        }
        return result;
    }
}

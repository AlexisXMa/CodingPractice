package design;

// 359. Logger Rate Limiter

import java.util.*;

public class LoggerRateLimiter {
    // Method: HashMap
    // Time = O(1) for hashmap lookup and update
    // Space = O(n), n = the size of all incoming messages

    // msgMap stores <Message, timestamp> pairs
    private Map<String, Integer> msgMap;

    public LoggerRateLimiter() {
        this.msgMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.msgMap.containsKey(message)) {
            this.msgMap.put(message, timestamp);
            return true;
        }
        int oldTimestamp = this.msgMap.get(message);
        if (timestamp >= oldTimestamp + 10) {
            this.msgMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

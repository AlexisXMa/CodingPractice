package design;

// 981. Time Based Key-Value Store

import java.util.*;

public class TimeBasedKeyValueStore {
    // Method: Binary Search
    static class Data {
        String value;
        int timestamp;
        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    // Time = O(log n)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Data> dataList = map.get(key);
        return binarySearch(dataList, timestamp);
    }

    private String binarySearch(List<Data> dataList, int timestamp) {
        int left = 0;
        int right = dataList.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Data data = dataList.get(mid);
            if (data.timestamp == timestamp) {
                return data.value;
            } else if (data.timestamp > timestamp) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (dataList.get(right).timestamp <= timestamp) {
            return dataList.get(right).value;
        } else if (dataList.get(left).timestamp <= timestamp) {
            return dataList.get(left).value;
        }
        return "";
    }
}

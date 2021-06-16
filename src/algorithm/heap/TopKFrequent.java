package algorithm.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0) {
            return combo;
        }
        Map<String, Integer> dictionary = getDictionary(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new MyComparator());
        for (Map.Entry<String, Integer> entry: dictionary.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    private Map<String, Integer> getDictionary(String[] combo) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word: combo) {
            Integer key = dictionary.get(word);
            if (key == null) {
                dictionary.put(word, 1);
            } else {
                dictionary.put(word, key + 1);
            }
        }
        return dictionary;
    }

    static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return 0;
            }
            return o1.getValue() < o2.getValue() ? -1 : 1;
        }
    }
}

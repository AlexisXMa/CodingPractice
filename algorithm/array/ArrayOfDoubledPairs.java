package algorithm.array;

// 954. Array of Doubled Pairs

import java.util.*;

public class ArrayOfDoubledPairs {
    // Method: Greedy
    // Time = O(n log n); Space = O(n)
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> numList = new ArrayList<>(map.keySet());
        Collections.sort(numList, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (int num: numList) {
            int currCount = map.get(num);
            if (currCount == 0) {
                continue;
            }
            int nextCount = map.getOrDefault(2 * num, 0);
            if (currCount > nextCount) {
                return false;
            }
            map.put(2 * num, nextCount - currCount);
        }
        return true;
    }
}

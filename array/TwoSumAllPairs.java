package algorithm.array;

/*
Find all pairs of elements in a given array that sum to the given target number.
Return all the pairs of indices.

Assumptions:
The given array is not null and has length of at least 2.
 */

import java.util.*;

public class TwoSumAllPairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // key: number, value: list of all possible indices.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int j: indices) {
                    result.add(Arrays.asList(i, j));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }
}

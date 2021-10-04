package algorithm.array;

/*
Determine if there exists three elements in a given array that sum to the given target number.
Return all the triple of values that sums to target.

Assumptions: 1. The given array is not null and has length of at least 3
2. No duplicate triples should be returned, order of the values in the tuple does not matter
 */

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            // find a[i] + a[j] + a[k] = target with i < j < k
            // ignore all duplicate a[i]
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int temp = array[left] + array[right];
                if (array[i] + temp == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    // ignore all possible duplicate a[j]
                    while(left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (array[i] + temp < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

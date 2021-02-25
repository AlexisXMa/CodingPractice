package algorithm.array;

import java.util.*;

public class TwoSumII {
    public boolean twoSum(int[] array, int target) {
        // Method 2: use HashSet to record the previous traversed values
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(target - array[i])) {
                return true;
            }
            set.add(array[i]);
        }
        return false;
    }
}

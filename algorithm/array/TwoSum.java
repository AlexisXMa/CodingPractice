package algorithm.array;

import java.util.*;

public class TwoSum {
    public boolean twoSum(int[] array, int target) {
        // Method 1: sort the array first, then use two pointers
        // time = O(n log n) + O(n); space = O(1)
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public boolean twoSum2(int[] array, int target) {
        // Method 2: use HashSet to record the previous traversed values
        // time = O(n); space = O(n)
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

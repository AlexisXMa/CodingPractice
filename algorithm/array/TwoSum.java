package algorithm.array;

import java.util.*;

public class TwoSum {
    public boolean twoSum(int[] array, int target) {
        // Method 1: sort the array first, then use two pointers
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
}

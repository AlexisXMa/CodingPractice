package algorithm.array;

/*
Find all pairs of elements in a given array that sum to the pair the given target number.
Return all the distinct pairs of values.
 */

import java.util.*;

public class TwoSumAllPairsII {
    // Method 1: sort the array first and use two pointers.
    public List<List<Integer>> allPairs(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            // ignore all the consecutive duplicate values when we want
            // to determine the smaller element of the pair.
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }
            int sum = array[left] + array[right];
            if (sum == target) {
                result.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

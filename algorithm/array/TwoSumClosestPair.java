package algorithm.array;

/*
Find the pair of elements in a given array that sum to a value that is
closest to the given target number. Return the values of the two numbers.

Assumptions:
The given array is not null and has length of at least 2
 */

import java.util.*;

public class TwoSumClosestPair {
    public List<Integer> closest(int[] array, int target) {
        Arrays.sort(array);
        List<Integer> res = new ArrayList<>();
        res.add(null);
        res.add(null);
        int left = 0, right = array.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while(left < right) {
            int diff = target - (array[left] + array[right]);
            if (Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
                res.set(0, array[left]);
                res.set(1, array[right]);
            }
            if (diff == 0) {
                return res;
            } else if (diff < 0) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumClosestPair sol = new TwoSumClosestPair();
        System.out.println(sol.closest(new int[]{1, 4, 7, 13}, 7)); // return [1, 7]
    }
}

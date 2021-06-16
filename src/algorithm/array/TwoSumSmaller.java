package algorithm.array;

/*
Determine the number of pairs of elements in a given array
that sum to a value smaller than the given target number.
 */

import java.util.Arrays;

public class TwoSumSmaller {
    public int smallerPairs(int[] array, int target) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1, count = 0;
        while (left < right) {
            if (array[left] + array[right] < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}

package algorithm.array;

/*
Determine if there exists a set of four elements in a given array that sum to the given target number.
Assumptions: 1. The given array is not null and has length of at least 4
 */

import java.util.*;

public class FourSum {
    public boolean exist(int[] array, int target) {
        // Method 1: sort the array first, O(n^3)
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int curTarget = target - array[i] - array[j];
                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == curTarget) {
                        return true;
                    } else if (sum < curTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    static class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean exist2(int[] array, int target) {
        // Method 2: HashMap O(n^2)
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[j] + array[i];
                // guarantee that another pair has right index smaller than
                // the current pair's left index
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
                    return true;
                }
                // we only need to store the pair with smallest right index.
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }
}

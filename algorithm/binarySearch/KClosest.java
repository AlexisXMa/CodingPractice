package algorithm.binarySearch;

/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order,
find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.
 */

public class KClosest {
    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        if (k == 0) {
            return new int[0];
        }
        if (k > array.length) {
            return array;
        }
        int left = closest(array, target);
        int right = left + 1;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right <= array.length - 1) {
                if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                    res[i] = array[left--];
                } else {
                    res[i] = array[right++];
                }
            } else if (left >= 0) {
                res[i] = array[left--];
            } else {
                res[i] = array[right++];
            }
        }
        return res;
    }

    public int closest(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ? left : right;
    }
}

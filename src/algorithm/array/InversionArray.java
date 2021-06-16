package algorithm.array;

public class InversionArray {
    // Requirement: TC = O(n log n) => mergesort
    // SC = O(n)
    public int[] countArray(int[] array) {
        // the indexArray contains the indices in the original array,
        // and it will be sorted by the corresponding number in the
        // original array.
        int[] indexArray = initialIndexArray(array);
        // The countArray is the actual return array.
        int[] countArray = new int[array.length];
        // the helper array is to help the merge sort.
        int[] helper = new int[array.length];
        mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
        return countArray;
    }

    // The indices are just 0 ~ (array.length - 1)
    private int[] initialIndexArray(int[] array) {
        int[] indices = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        return indices;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
        // base case: return to previous level if there is only one element remaining
        if (left >= right) {
            return;
        }
        // 1. partition into left and right first
        int mid = left + (right - left) / 2;
        // 2. mergeSort in smaller portions: left and right
        mergeSort(array, indexArray, countArray, helper, left, mid);
        mergeSort(array, indexArray, countArray, helper, mid + 1, right);
        // 3. merge the two and computee the countArray
        merge(array, indexArray, countArray, helper, left, mid, right);
    }
    /* global indexing  0    1    2    3
    int[] array      = {4,   1,   3,   2};
                      left            right
                            mid
                             l
                                  r
                            cur
    int[] indexArray = {1,   0,   3,   2}; provide original indexing and to be re-sorted
    int[] helper     = {1,   0,   3,   2}; initial state of indexArray after last changes and before new changes
    int[] countArray = {1,   0,   1,   0};
    */
    private void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
        copyArray(indexArray, helper, left, right); // copy from indexArray to helper given left/right boundaries
        // l(or helper[l]) and r(or helper[r]) are pointers for comparisons
        int l = left; // starting position of left half before merging
        int r = mid + 1; // starting position of right half before merging
        int cur = left; //
        // helper[l or r]: per mergesort partition, map the current l and r pointers to actually effective positions
        //                 in "array" indexing
        // High-level: for a mergesort partition part from "left" to "right," perform “谁小移谁(move smaller one to cur)”
        // for array elements' indexes (instead of array elements themselves),
        // by referring from helper(previously sorted indexes) and applying changes to indexArray
        while (l <= mid) {
            // when sorting the indexArray, we use the corresponding value in the
            // original array
            // right scanner exceeds right bound of this partition || array[effective l] <= array[effective r]
            if (r > right || array[helper[l]] <= array[helper[r]]) {
                // count @helper[l] is: how many steps "r" has moved from its original position ("mid + 1")
                countArray[helper[l]] += (r - mid - 1);
                //
                indexArray[cur++] = helper[l++];
            } else { // r <= right || array[helper[l]] > array[helper[r]]
                //
                indexArray[cur++] = helper[r++];
            }
        }
    }

    // copy from indexArray to helper array
    private void copyArray(int[] indexArray, int[] helper, int left, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = indexArray[i];
        }
    }
}

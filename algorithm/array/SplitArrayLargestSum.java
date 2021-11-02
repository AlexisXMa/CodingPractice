package algorithm.array;

// 410. Split Array Largest Sum

public class SplitArrayLargestSum {
    // Method: Binary Search
    // Time = O(n log(sum of array))
    // Space = O(1)
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        long left = max;
        long right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (valid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }

    private boolean valid(int[] nums, int m, long max) {
        int count = 1;
        long curSum = 0;
        for (int num: nums) {
            curSum += num;
            if (curSum > max) {
                curSum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
